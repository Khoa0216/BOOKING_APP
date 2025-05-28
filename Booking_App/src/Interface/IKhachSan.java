/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;
import javax.swing.JTable;
/**
 *
 * @author bobui
 */
public interface IKhachSan<Entity, Key> {
    //public Entity select(Key n);
    public void loadTableKS(JTable table); // thêm tham số JTable như mình đã gợi ý
}
