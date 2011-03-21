package ro.cuzma.larry.persistance.common;

import java.util.ArrayList;
import java.util.List;

public class EntityList<E extends Entity<?>> {
    List<E> entityList = new ArrayList<E>(); ;

    public E getEntityById(Object id) {
        E retEntity = null;
        for (E ent : entityList) {
            if (ent.getId().equals(id)) {
                retEntity = ent;
                break;
            }
        }
        return retEntity;
    }

    public void add(E el) {
        entityList.add(el);
    }

    public List<E> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<E> entityList) {
        this.entityList = entityList;
    }

}
