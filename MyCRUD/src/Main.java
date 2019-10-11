import java.util.*;

public class Main {

    public static void main(String[] args) {
            try{
                DatabaseConnection con = new DatabaseConnection();
                Scanner in = new Scanner(System.in);
                Controller control = new Controller();
                User user = new User();

                con.myConnection();

                System.out.println("user management choices");
                System.out.println("1. Inserting new user \n" + "2. View user list \n" + "3. Updating user info \n" + "4. Deleting user info \n");
                System.out.print("Insert choice: ");
                int ch = in.nextInt();
                switch(ch){
                    case 1:
                        System.out.println("Enter user firstname: ");
                        user.setFname(in.next());
                        System.out.println("Enter user lastname: ");
                        user.setLname(in.next());
                        System.out.println("Enter user email: ");
                        user.setEmail(in.next());
                        control.insertUsers(user);
                        break;

                    case 2:
                        List<User> userList = control.displayAll();
                        for(User list : userList){
                            System.out.println(list.getUserUID() + ", " + list.getFname() + "," + list.getLname() + "," + list.getEmail());
                        }
                        break;

                    case 3:
                        System.out.println("Choose what info to be updated \n" + "1. User Name \n" + "2. User Lastname \n" + "3. User Gmail \n");
                        System.out.println("Enter Choice: ");
                        int ch2 = in.nextInt();
                        System.out.println("Enter user UID: ");
                        user.setUserUID(in.next());
                        System.out.println("Enter user new info: ");
                        user.setNewInfo(in.next());

                        String col;

                        if(ch2 == 1){
                            col= "userName";
                            control.updatingUserInfo(col, user.getUserUID(), user.getNewInfo());
                        }
                        else if(ch2 == 2){
                            col = "userLastName";
                            control.updatingUserInfo(col, user.getUserUID(), user.getNewInfo());
                        }
                        else if(ch2 == 3 ){
                            col = "email";
                            control.updatingUserInfo(col, user.getUserUID(), user.getNewInfo());
                        }
                        else{
                            System.out.print("Choice is not included in the menu. Pls try again\n");
                        }

                        break;

                    case 4:
                        System.out.println("Enter user UID: ");
                        user.setUserUID(in.next());
                        control.deleteInfo(user.getUserUID());
                        break;

                     default: System.out.print("Choice is not included in the menu. Pls try again \n");

                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }


}
