package consoleuserapp;

import java.io.*;
import java.util.*;

public class ConsoleUserApp {
    
    public static void main(String[] args) throws IOException, Exception {
        Scanner in = new Scanner(System.in);
        
        List<CreateUser> users = new ArrayList();
        String first_name;
        String last_name;
        String email = "";
        String[] role = new String[1];
        long[] mob_tel = new long[1];
        String text_for_file;
        
        String role1 = "USER";
        String role2 = "CUSTOMER";
        String role3 = "ADMIN";
        String role4 = "PROVIDER";
        String role5 = "SUPER_ADMIN";
        
        long num1 = 0, num2 = 0, num3 = 0;
        
        String fileName = "SaveUsers.txt";
        File file = new File(fileName);
        
        // create
        if(!file.exists()){
            file.createNewFile();
            System.out.println("Файл для записи пользователей успешно создан");
        } 
        else{
            System.out.println("Файл для записи пользователей уже существует");
        }
        
        while(true){
            System.out.println("Меню");
            System.out.println("1. Создать пользователя");
            System.out.println("2. Редактировать пользователя");
            System.out.println("3. Получить данные о пользователе");
            System.out.println("4. Получить список пользователей");
            System.out.println("5. Удалить пользователя");
            System.out.println("0. Выход");
            System.out.print("Выберите операцию: ");
            int a = in.nextInt();
            switch(a){
                case 1:
                    System.out.print("Введите имя: ");
                    first_name = in.next();

                    System.out.print("Введите фамилию: ");
                    last_name = in.next();

                    boolean correctEmail = false;
                    while(correctEmail == false){
                        System.out.print("Введите почту: ");
                        email = in.next();
                        if(Validators.emailValidator(email)){
                            correctEmail = true;
                        }
                        else{
                            System.out.println("Неверный формат почты(верный ******@****.***), попробуйте ещё");
                        }
                    }
                    
                    System.out.println("1)" + role1 + " 2)" + role2 + " 3)" + role3 + " 4)" + role4 + " 5)" + role5);
                    System.out.print("Выберите роль: ");
                    int b = 0;
                    try{
                        b = in.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                    }
                    role = new String[2];
                    switch(b){
                        case 1:
                            role[0] = role1;
                            break;
                        case 2:
                            role[0] = role2;
                            break;
                        case 3:
                            role[0] = role3;
                            break;
                        case 4:
                            role[0] = role4;
                            break;
                        case 5:
                            role = new String[1];
                            role[0] = role5;
                            break;
                        default:
                            System.out.println("Операция выбрана не верно, в следующий раз будьте внимательнее");
                    }
                    if(role[0].equals(role5)){
                        System.out.println("Ваша роль - " + role5);
                    }
                    else{
                        String roles = role[0];
                        System.out.print("Желаете еще одну роль?(YES(y)/NO(n)): ");
                        String yn = in.next();
                        if(yn.equals("y")){
                            if(role[0].equals(role1) || role[0].equals(role2)){
                                System.out.println("1)" + role3 + " 2)" + role4);
                                System.out.print("Выберите дополнительную роль: ");
                                int c = 0;
                                try{
                                    c = in.nextInt();
                                }catch(InputMismatchException e){
                                    System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                                }
                                switch(c){
                                    case 1:
                                        role[1] = role3;
                                        break;
                                    case 2:
                                        role[1] = role4;
                                        break;
                                    default:
                                        System.out.println("Операция выбрана не верно, в следующий раз будьте внимательнее");
                                }
                            }
                            else if(role[0].equals(role3) || role[0].equals(role4)){
                                System.out.println("1)" + role1 + " 2)" + role2);
                                System.out.print("Выберите дополнительную роль: ");
                                int d = 0;
                                try{
                                    d = in.nextInt();
                                }catch(InputMismatchException e){
                                    System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                                }
                                switch(d){
                                    case 1:
                                        role[1] = role1;
                                        break;
                                    case 2:
                                        role[1] = role2;
                                        break;
                                    default:
                                        System.out.println("Операция выбрана не верно, в следующий раз будьте внимательнее");
                                }
                            }    
                        }
                        else if(yn.equals("n")){
                            role = new String[1];
                            role[0] = roles;
                        }    
                    }

                    System.out.print("Выберите количество моб. тел.(от 1 до 3): ");
                    int f = 0;
                    try{
                        f = in.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                    }
                    if(f == 1){
                        mob_tel = new long[1];
                        boolean correctPhone = false;
                        while(correctPhone == false){
                            System.out.print("Введите ном. тел. : ");
                            try{
                                num1 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********, 12 цифр), попробуйте ещё");
                            }
                        }
                        mob_tel[0] = num1;
                    }
                    else if(f == 2){
                        mob_tel = new long[2];
                        
                        boolean correctPhone1 = false;
                        while(correctPhone1 == false){
                            System.out.print("Введите 1 ном. тел. : ");
                            try{
                                num1 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone1 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********, 12 цифр), попробуйте ещё");
                            }
                        }
                        
                        boolean correctPhone2 = false;
                        while(correctPhone2 == false){
                            System.out.print("Введите 2 ном. тел. : ");
                            try{
                                num2 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num2)){
                            correctPhone2 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********, 12 цифр), попробуйте ещё");
                            }
                        }
                        mob_tel[0] = num1;
                        mob_tel[1] = num2;
                    }
                    else if(f == 3){
                        mob_tel = new long[3];
                        
                        boolean correctPhone1 = false;
                        while(correctPhone1 == false){
                            System.out.print("Введите 1 ном. тел. : ");
                            try{
                                num1 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone1 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********, 12 цифр), попробуйте ещё");
                            }
                        }
                        
                        boolean correctPhone2 = false;
                        while(correctPhone2 == false){
                            System.out.print("Введите 2 ном. тел. : ");
                            try{
                                num2 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num2)){
                            correctPhone2 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********, 12 цифр), попробуйте ещё");
                            }
                        }
                        
                        boolean correctPhone3 = false;
                        while(correctPhone3 == false){
                            System.out.print("Введите 3 ном. тел. : ");
                            try{
                                num3 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num3)){
                            correctPhone3 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********, 12 цифр), попробуйте ещё");
                            }
                        }
                        mob_tel[0] = num1;
                        mob_tel[1] = num2;
                        mob_tel[2] = num3;
                    }
                    else{
                        System.out.println("Такой операции не существует, в следующий раз будьте внимательнее");
                    }
                    
                    CreateUser new_user = new CreateUser(first_name, last_name, email, role, mob_tel);
                    users.add(new_user);
                    text_for_file = new_user.userInfo();
                    WorkWithFile.saveToFile(file, text_for_file);
                    System.out.println("Новый пользователь '" + first_name + " " + last_name + "' успешно добавлен и сохранён в файл");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Введите индекс пользователя, данные которого хотите изменить(индексы начинаются с 0): ");
                    try{
                        int g = in.nextInt();                   
                        CreateUser change_user = users.get(g);
                        System.out.println(change_user.userInfo());
                        System.out.println();
                        System.out.println("Приступим  к изменениям");
                        UpdateUser.updateInfo(users, g, file);
                        System.out.println("\nВот результат изменений:");
                        ShowUser.showUsers(users);
                        System.out.println();
                    }catch(IndexOutOfBoundsException e){
                        System.out.println("В данный момент такого пользователя не существует");
                        System.out.println();
                    }
                    break;
                case 3:
                    ShowUser.showUser(users);
                    System.out.println();
                    break;
                case 4:
                    ShowUser.showUsers(users);
                    System.out.println();
                    break;
                case 5:
                    DeleteUser.deleteUser(users, file);                  
                    System.out.println();
                    break;
                case 0:
                    System.out.println("До свидания)");
                    System.exit(0); 
                default:
                    System.out.println("Такой операции не существует, пожалуйста выберите операцию от 1 до 5 (или 0)\n");
            }
            
        }
        
    }

}
