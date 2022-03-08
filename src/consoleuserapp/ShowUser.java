package consoleuserapp;

import java.util.*;

public class ShowUser {
    
    public static void showUser(List<CreateUser> users){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите индекс пользователя, которого хотите найти(индексы начинаются с 0): ");
        try{
            int g = in.nextInt();
            System.out.println("Отлично, такой пользователь существует");
            System.out.println("Вот информация о нём:");
            CreateUser search_user = users.get(g);
            System.out.println(search_user.userInfo());
        }catch(IndexOutOfBoundsException e){
            System.out.println("В данный момент такого пользователя не существует");
            System.out.println();
        }
    }
    
    public static void showUsers(List<CreateUser> users){
        System.out.println("Список пользователей:");
        if(users.size() == 0){
            System.out.println("В данный момент список пользователей пуст");
        }
        for(CreateUser user : users){
            System.out.println(user.userInfo());
        }
    }
    
}
