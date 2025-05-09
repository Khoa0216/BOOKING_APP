package Interface;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IPhongKS<Entity, Key> {
    public void insert(Entity e);
    public void update(Entity e);
    public void delete(Key k);
    public List<Entity> selectAll();
    public Entity selectByID(Key k);
}
