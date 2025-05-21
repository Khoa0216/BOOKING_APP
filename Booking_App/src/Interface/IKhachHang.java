/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;


/**
 *
 * @author bobui
 */
public interface IKhachHang<Entity,key> {
    public Entity select(key n);
    public void update(Entity n);
}
