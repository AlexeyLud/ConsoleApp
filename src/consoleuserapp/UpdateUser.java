package consoleuserapp;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UpdateUser {
    
    public static void updateInfo(List<CreateUser> users, int g, File file) throws IOException, Exception{
        Scanner in = new Scanner(System.in);
        String text_for_file = "";
        boolean change = false;
        while(change == false){
            System.out.println("Что вы хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Фамилию");
            System.out.println("3. Почту");
            System.out.println("4. Роль");
            System.out.println("5. Номер(а) телефона");
            System.out.println("0. Выход в меню");
            CreateUser search_user = users.get(g);
            String[] new_role = new String[1];
            long[] new_mob_tel = new long[1];
            String role1 = "USER";
            String role2 = "CUSTOMER";
            String role3 = "ADMIN";
            String role4 = "PROVIDER";
            String role5 = "SUPER_ADMIN";
            long num1 = 0, num2 = 0, num3 = 0;
            System.out.print("Выберите операцию: ");
            int a = 0;
            try{
                a = in.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
            }
            switch(a){
                case 1:           
                    System.out.print("Введите новое имя: ");
                    String new_first_name = in.next();
                    search_user = changeFirstName(search_user, new_first_name);
                    System.out.println("Отлично, имя изменено");
                    System.out.println();
                    continue;
                case 2:
                    System.out.print("Введите новую фамилию: ");
                    String new_last_name = in.next();
                    search_user = changeLastName(search_user, new_last_name);
                    System.out.println("Отлично, фамилия изменена");
                    System.out.println();
                    continue;
                case 3:
                    boolean correctEmail = false;
                    while(correctEmail == false){
                        System.out.print("Введите новую почту: ");
                        String email = in.next();
                        if(Validators.emailValidator(email)){
                            search_user = changeEmail(search_user, email);
                            System.out.println("Отлично, почта изменена");
                            correctEmail = true;
                        }
                        else{
                            System.out.println("Неверный формат почты(верный ******@****.***), попробуйте ещё");
                        }
                    }
                    System.out.println();
                    continue;
                case 4:
                    System.out.println("1)" + role1 + " 2)" + role2 + " 3)" + role3 + " 4)" + role4 + " 5)" + role5);
                    System.out.print("Выберите новую роль: ");
                    int b = 0;
                    try{
                        b = in.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                    }
                    new_role = new String[2];
                    switch(b){
                        case 1:
                            new_role[0] = role1;
                            break;
                        case 2:
                            new_role[0] = role2;
                            break;
                        case 3:
                            new_role[0] = role3;
                            break;
                        case 4:
                            new_role[0] = role4;
                            break;
                        case 5:
                            new_role = new String[1];
                            new_role[0] = role5;
                            break;
                        default:
                            System.out.println("Операция выбрана не верно, в следующий раз будьте внимательнее");
                    }
                    if(new_role[0].equals(role5)){
                        System.out.println("Ваша новая роль - " + role5);
                    }
                    else{
                        String roles = new_role[0];
                        System.out.print("Желаете еще одну роль?(YES(y)/NO(n)): ");
                        String yn = in.next();
                        if(yn.equals("y")){
                            if(new_role[0].equals(role1) || new_role[0].equals(role2)){
                                System.out.println("1)" + role3 + " 2)" + role4);
                                System.out.print("Выберите новую дополнительную роль: ");
                                int c = 0;
                                try{
                                    c = in.nextInt();
                                }catch(InputMismatchException e){
                                    System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                                }
                                switch(c){
                                    case 1:
                                        new_role[1] = role3;
                                        break;
                                    case 2:
                                        new_role[1] = role4;
                                        break;
                                    default:
                                        System.out.println("Операция выбрана не верно, в следующий раз будьте внимательнее");
                                }
                            }
                            else if(new_role[0].equals(role3) || new_role[0].equals(role4)){
                                System.out.println("1)" + role1 + " 2)" + role2);
                                System.out.print("Выберите новую дополнительную роль: ");
                                int d = 0;
                                try{
                                    d = in.nextInt();
                                }catch(InputMismatchException e){
                                    System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                                }
                                switch(d){
                                    case 1:
                                        new_role[1] = role1;
                                        break;
                                    case 2:
                                        new_role[1] = role2;
                                        break;
                                    default:
                                        System.out.println("Операция выбрана не верно, в следующий раз будьте внимательнее");
                                }
                            }    
                        }
                        else if(yn.equals("n")){
                            new_role = new String[1];
                            new_role[0] = roles;
                        }    
                    }
                    search_user = changeRole(search_user, new_role);
                    System.out.println("Отлично, роль изменена");
                    System.out.println();
                    continue;
                case 5:
                    System.out.print("Выберите новое количество моб. тел.(от 1 до 3): ");
                    int f = 0;
                    try{
                        f = in.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Неверный ввод(нужно было ввести число), в следующий раз будьте внимательнее");
                    }
                    if(f == 1){
                        new_mob_tel = new long[1];
                        boolean correctPhone = false;
                        while(correctPhone == false){
                            System.out.print("Введите новый ном. тел. : ");
                            try{
                                num1 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********), попробуйте ещё");
                            }
                        }
                        new_mob_tel[0] = num1;
                    }
                    else if(f == 2){
                        new_mob_tel = new long[2];
                        
                        boolean correctPhone1 = false;
                        while(correctPhone1 == false){
                            System.out.print("Введите новый 1 ном. тел. : ");
                            try{
                                num1 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone1 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********), попробуйте ещё");
                            }
                        }
                        
                        boolean correctPhone2 = false;
                        while(correctPhone2 == false){
                            System.out.print("Введите новыый 2 ном. тел. : ");
                            try{
                                num2 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num2)){
                            correctPhone2 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********), попробуйте ещё");
                            }
                        }
                        new_mob_tel[0] = num1;
                        new_mob_tel[1] = num2;
                    }
                    else if(f == 3){
                        new_mob_tel = new long[3];
                        
                        boolean correctPhone1 = false;
                        while(correctPhone1 == false){
                            System.out.print("Введите новый 1 ном. тел. : ");
                            try{
                                num1 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone1 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********), попробуйте ещё");
                            }
                        }
                        
                        boolean correctPhone2 = false;
                        while(correctPhone2 == false){
                            System.out.print("Введите новый 2 ном. тел. : ");
                            try{
                                num2 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num1)){
                            correctPhone1 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********), попробуйте ещё");
                            }
                        }
                        
                        boolean correctPhone3 = false;
                        while(correctPhone3 == false){
                            System.out.print("Введите новый 3 ном. тел. : ");
                            try{
                                num3 = in.nextLong();
                            }catch(InputMismatchException e){
                                System.out.println("Неверный ввод(номер должен состоять из цифр), попытайтесь ещё");
                            }
                            if(Validators.phoneValidator(num3)){
                            correctPhone3 = true;
                            }
                            else{
                                System.out.println("Неверный формат номера телефона(верный 375*********), попробуйте ещё");
                            }
                        }
                        new_mob_tel[0] = num1;
                        new_mob_tel[1] = num2;
                        new_mob_tel[2] = num3;
                    }
                    search_user = changeMobTel(search_user, new_mob_tel);
                    System.out.println("Отлично, номер(а) телефона изменeн(ы)");
                    System.out.println();
                    continue;
                case 0:
                    System.out.println("Перезаписываем данные и возвращаемся в меню");
                    for(CreateUser user : users){
                        text_for_file += user.userInfo() + '\n';
                    }
                    WorkWithFile.updateToFile(file, text_for_file);
                    change = true;
                    break;
                default:
                    System.out.println("Такой операции не существует, пожалуйста выберите операцию от 1 до 5 (или 0)\n");
            }
        }  
    }
    
    private static CreateUser changeFirstName(CreateUser user, String new_first_name){
        CreateUser changed_user = user;
        changed_user.setFirstName(new_first_name);
        return changed_user;
    } 
    
    private static CreateUser changeLastName(CreateUser user, String new_last_name){
        CreateUser changed_user = user;
        changed_user.setLastName(new_last_name);
        return changed_user;
    }
    
    private static CreateUser changeEmail(CreateUser user, String email){
        CreateUser changed_user = user;
        changed_user.setEmail(email);
        return changed_user;
    }
    
    private static CreateUser changeRole(CreateUser user, String[] role){
        CreateUser changed_user = user;
        changed_user.setRole(role);
        return changed_user;
    }
    
    private static CreateUser changeMobTel(CreateUser user, long[] mob_tel){
        CreateUser changed_user = user;
        changed_user.setMobTel(mob_tel);
        return changed_user;
    }
   
}
