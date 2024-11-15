package org.example.jurassic.seguridad;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Aspect
@Configuration
public class SecurityServicio {

    public String getRolUsuarioActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()){
            for (GrantedAuthority authority: authentication.getAuthorities()){
                return authority.getAuthority();
            }
        }
        return null;
    }

    public String getUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserDetails)principal).getUsername();
        }else {
            return principal.toString();
        }
    }

}
