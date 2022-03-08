package consoleuserapp;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DeleteUser {
    
    public static void deleteUser(List<CreateUser> users, File file) throws IOException{
        String text_for_file = "";
        ShowUser.showUsers(users);
        Scanner in = new Scanner(System.in);
        System.out.print("Введите индекс пользователя, которого хотите удалить(индексы начинаются с 0): ");
        try{
            int g = in.nextInt();
            CreateUser del_user = users.get(g);
            String del_first_name = del_user.getFirstName();
            String del_last_name = del_user.getLastName();
            users.remove(g);
            System.out.println("Пользователь '" + del_first_name + " " + del_last_name + "' успешно удалён");
            ShowUser.showUsers(users);
            for(CreateUser user : users){
                 text_for_file += user.userInfo() + '\n';
            }
            WorkWithFile.updateToFile(file, text_for_file);
        }catch(IndexOutOfBoundsException e){
            System.out.println("В данный момент такого пользователя не существует");
            System.out.println();
        }
        
    }
    
}
