package Tema6.gestorContacto;

import java.util.ArrayList;
import java.util.List;

public class agenda {
    private static List<contacto> contactosList=new ArrayList<>();

    List<contacto> getContactosList() {
        return contactosList;
    }

    void setContactosList(contacto contacto) {
        contactosList.add(contacto);
    }
    void borrarContacto(int i){
        contactosList.remove(i);
        contacto.getNombreUnico().remove(i);
    }
}
