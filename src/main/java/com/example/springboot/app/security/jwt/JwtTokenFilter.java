package com.example.springboot.app.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springboot.app.security.service.UserDetailsServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Los filtros sirve para validar que un token es valido
 * Se ejecuta por cada petición, comprueba que sea valido el token
 * Utiliza el provider para validar que sea valido
 * Si es valido permite acceso al recurso si no lanza una excepción
 * 
 * OncePerRequestFilter Clase base de filtro que tiene como objetivo garantizar una 
 * sola ejecución por envío de solicitud, en cualquier contenedor de servlet.
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;// inyectamos la clase jwtProviderq que contiene los metodos para validar el token

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    // El token esta formado por:
     // cabecera --> Authorization: Bearer token
    //Hace las comprobaciones
    // Este metodo se hace cada vez que se le haga una peticion al sever
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);//obtenemos el token de la solicitud http

            if(token != null && jwtProvider.validateToken(token)){
            	//Obtenemos el nombre del usuario
                String nombreUsuario = jwtProvider.getNombreUsuarioDelToken(token);
                //Cargamos el usuario asociado al token
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                //Autenticamos que el usuario con el token, 
                //son correctos para poder hacer uso de los metodos del controllet a los que este autorizado acorde a su rol
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
                                null, userDetails.getAuthorities());
                //Establecemos la seguridad, aporbando el token como correcto
                SecurityContextHolder.getContext().setAuthentication(auth);

            }
        }catch (Exception e){
            logger.error("Fail en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(request, response);//Respondemos a la peticion
    }


    //Obtenemos el token sin Bearer + el espacio
    //Beare un formato que nos permite la utorizacion de un usuario cuando trabajams con token
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        System.out.println("header: "+header);//muestra en consola que es bearer, lo cual iidica que es un token
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;

    }
}
