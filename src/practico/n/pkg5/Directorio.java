/*

 */
package modelo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Kjellfrid Bjerkeli
 */

   public class Directorio {
    private TreeMap<Long, Cliente> mapa = new TreeMap<>();

    // A) agregarContacto(teléfono, cliente)
    public boolean agregarContacto(Long tel, Cliente c) {
        if (mapa.containsKey(tel)) return false;
        mapa.put(tel, c);
        return true;
    }

    // B) buscarContacto(teléfono)
    public Cliente buscarContacto(Long tel) { return mapa.get(tel); }

    // C) buscarTelefono(apellido) -> Set<Long>
    public Set<Long> buscarTelefono(String apellido) {
        Set<Long> res = new TreeSet<>();
        for (Map.Entry<Long, Cliente> e : mapa.entrySet()) {
            if (e.getValue().getApellido().equalsIgnoreCase(apellido)) res.add(e.getKey());
        }
        return res;
    }

    
    public ArrayList<Cliente> buscarContactos(String ciudad) {
        ArrayList<Cliente> res = new ArrayList<>();
        for (Cliente c : mapa.values()) {
            if (c.getCiudad().equalsIgnoreCase(ciudad) && !res.contains(c)) res.add(c);
        }
        return res;
    }

    public boolean borrarContacto(Long tel) { return mapa.remove(tel) != null; }

    public Set<Long> keySet() { return mapa.keySet(); }
    public Set<Map.Entry<Long,Cliente>> entrySet() { return mapa.entrySet(); }

    public int borrarPorDni(long dni) {
        ArrayList<Long> aBorrar = new ArrayList<>();
        for (Map.Entry<Long,Cliente> e : mapa.entrySet())
            if (e.getValue().getDni() == dni) aBorrar.add(e.getKey());
        for (Long tel : aBorrar) mapa.remove(tel);
        return aBorrar.size();
    }
}

