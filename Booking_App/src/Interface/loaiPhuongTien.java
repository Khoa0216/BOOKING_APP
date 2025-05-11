/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.util.List;
/**
 *
 * @author Admin
 */
public interface loaiPhuongTien<Entity, Key> {
    public void insert(Entity e);
    public void update(Entity e);
    public void delete(Key k);
    public List<Entity> selectAll();
    public Entity selectByID(Key k);
}
