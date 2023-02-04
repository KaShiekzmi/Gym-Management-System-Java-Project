import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.lang.*;
public class Gym_Management_System {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] Members = new String[200][12];
        String[][] trainer = new String[20][4];
        String[][] Machines = new String[15][12];
        String [] AdminInfo = new String[2];
        // Code For Interface...
        System.out.println("____________________________________________________________________________");
        System.out.println("                            WELCOME TO SYSTEM");
        System.out.println("____________________________________________________________________________");
        System.out.println("****************************************************************************");
        System.out.println("*********************  _______  *  _____  *****                           **");
        System.out.println("********************* |  _____| * |  ___| *****       **           **     **");
        System.out.println("********************* | |___    * | |     *****      ***___________***    **");
        System.out.println("********************* |  ___|   * | |     *****     ****-----------****   **");
        System.out.println("********************* | |       * | |___  *****      *** Stone Man ***    **");
        System.out.println("********************* |_|       * |_____| *****       **    GYM    **     **");
        System.out.println("*********************           *         *****                           **");
        System.out.println("************************  FITNESS CLUB  ************************************");
        System.out.println("****************************************************************************");
        System.out.println("*    *     *   WHEN LIFE GIVES YOU PAIN.....GO TO THE GYM   *    *    *    *");
        System.out.println("____________________________________________________________________________\n");
        // Importing our Files of Members ,Trainers, Machines, Admin Info and File Exception Handling...
        boolean loaded = true;
        while(loaded) {
            //..........................Storing data from Members' file to Members' 2d Array...........................
            try {
                File a1 = new File("Members.txt");
                Scanner input = new Scanner(a1);
                for (int i = 0; i < Members.length; i++) {
                    String ab = input.nextLine();
                    String[] data = ab.split("#");
                    for (int j = 0; j < Members[0].length; j++) {
                        Members[i][j] = data[j];
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists.So a New 'Members' File is Created\n");
                OutputStream os = new FileOutputStream("Members.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0 ; i < 200 ; i++){
                    for (int j = 0; j < 12; j++){
                        put.print("null#");
                    }
                    put.println();
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                System.exit(1);
            }
            //............................Storing data from Trainers' file to trainers' 2d Array.......................
            try {
                File a2 = new File("trainers.txt");
                Scanner cs = new Scanner(a2);
                for (int k = 0; k < trainer.length; k++) {
                    String bc = cs.nextLine();
                    String[] info = bc.split("#");
                    for (int s = 0; s < trainer[0].length; s++) {
                        trainer[k][s] = info[s];
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists.So a New 'trainers' File is Created\n");
                OutputStream os = new FileOutputStream("trainers.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0 ; i < 20 ; i++){
                    for (int j = 0; j < 4; j++){
                        put.print("null#");
                    }
                    put.println();
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                System.exit(1);
            }
            //..............................Storing data from Machines' file to Machines' 2d Array.....................
            try {
                File a3 = new File("Machines.txt");
                Scanner inp = new Scanner(a3);
                for (int k = 0; k < Machines.length; k++) {
                    String cd = inp.nextLine();
                    String[] Mach = cd.split("#");
                    for (int s = 0; s < Machines[0].length; s++) {
                        Machines[k][s] = Mach[s];
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists.So a New 'Machines' File is Created\n");
                OutputStream os = new FileOutputStream("Machines.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0 ; i < 15 ; i++){
                    for (int j = 0; j < 12; j++){
                        put.print("null#");
                    }
                    put.println();
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                System.exit(1);
            }
            //...............................Storing data from AdminInfo file to AdminInfo array.......................
            try {
                File a4 = new File("AdminInfo.txt");
                Scanner in = new Scanner(a4);
                String de = in.nextLine();
                String[] adInfo = de.split("#");
                for (int i = 0; i < AdminInfo.length; i++)
                    AdminInfo[i] = adInfo[i];
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists.So a New 'AdminInfo' File is Created");
                System.out.println("\nDefault Username: admin");
                System.out.println("Default Password: anything\n");
                OutputStream os = new FileOutputStream("AdminInfo.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0 ; i < 2; i++){
                    if(i==0){
                        put.print("admin#");
                    }
                    else{
                        put.print("anything#");}
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                System.exit(1);
            }
            loaded = false;
        }//While Loop Closes here
        login (Members, trainer, AdminInfo, Machines);
    }
    //............................................Login Menu Method....................................................
    public static void login(String[][] Members, String[][] trainer, String [] AdminInfo, String[][] Machines) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n1. Login");
        System.out.println("2. Change Login Credentials");
        System.out.println("0. Quit Program");
        System.out.print("Enter Your Choice: ");
        String cho = sc.next();
        String buffer = sc.nextLine();
        while (true){
            if (cho.equals("1") || cho.equals("2") || cho.equals("0"))
                break;
            else	{
                System.out.println("\n\n\t\tInvalid Choice.....Please Choose between 0-2\n");
                System.out.print("Enter Your Choice: ");
                cho = sc.next();
            }
        }
        if(cho.equals("1"))	{//...............Login Option.............................
            System.out.println("\n\n\t\t\t\t**********************");
            System.out.println("\t\t\t\t     SYSTEM LOGIN     ");
            System.out.println("\t\t\t\t  Login Into Account  ");
            System.out.println("\t\t\t\t**********************");
            System.out.print("\nEnter UserName: ");// ...Taking Username from Admin....
            String U_name = sc.next();
            boolean isValidUserName = false;
            do{
                if(U_name.equals(AdminInfo[0])){
                    isValidUserName = true;
                }
                else{
                    System.out.println("\n\tInvalid User Name! Please enter correct User Name or '0' to EXIT\n");
                    System.out.print("Enter UserName: ");
                    U_name = sc.next();
                    if (U_name.equals("0"))	System.exit(1);
                    isValidUserName = false;
                }

            }while(!isValidUserName);
            System.out.print("\nEnter Password: ");// ...Taking Password from Admin....
            String password = sc.next();
            boolean isValidPassword = false;
            do{
                if(password.equals(AdminInfo[1])){
                    isValidPassword = true;
                }
                else	{
                    System.out.println("\n\tInvalid Password! Please enter correct password or '0' to EXIT\n");
                    System.out.print("Enter Password: ");
                    password = sc.next();
                    if (password.equals("0"))	System.exit(1);
                    isValidPassword = false;
                }
            }while(!isValidPassword);
        }
        else if (cho.equals("2")){//...............Update Login Option................
            System.out.println("\n\t\t\t\t\t*************************");
            System.out.println("\t\t\t\t\t   Updating Login Info");
            System.out.println("\t\t\t\t\t*************************");
            System.out.println("\n");
            System.out.print("\nEnter Existing UserName: ");
            String U_name = sc.nextLine();
            do{
                if(U_name.equals(AdminInfo[0])){
                    break;
                }
                else	{
                    System.out.println("\n\tInvalid UserName! Please enter correct UserName or '0' to EXIT ");
                    System.out.print("\nEnter Existing UserName: ");
                    U_name = sc.nextLine();
                    if (U_name.equals("0"))	System.exit(1);
                }
            }while(true);
            System.out.print("Enter Existing Password: ");
            String password = sc.nextLine();
            do{
                if(password.equals(AdminInfo[1])){
                    break;
                }
                else{
                    System.out.println("\n\tInvalid Password! Please enter correct password or '0' to EXIT ");
                    System.out.print("\nEnter Existing Password: ");
                    password = sc.nextLine();
                    if (password.equals("0"))	System.exit(1);
                }
            }while(true);
            System.out.print("\nEnter new Username: ");
            AdminInfo[0] = sc.nextLine();
            String npss;
            while(true)	{
                System.out.print("\nEnter new Password: ");
                while(true)	{
                    npss = sc.nextLine();
                    if (npss.length() < 8)
                        System.out.println("\n\t\t8 characters is the minimum length for a password, kindly enter once again ");
                    else
                        break;
                }
                System.out.print("\nPlease confirm Password: \n");
                String con = sc.nextLine();
                if (npss.equals(con))	{
                    AdminInfo[1] = npss;
                    break;
                }
                else
                    System.out.print("\n\t\tNew password and the confirmation password cannot be different. Please try again \n");
            }
            try{//.....................Modifying AdminInfo File.......................
                PrintWriter myFile = new PrintWriter("./AdminInfo.txt");
                for(int i = 0;i< AdminInfo.length;i++) {
                    myFile.print(AdminInfo[i]+"#");
                }
                myFile.close();
            }catch(FileNotFoundException e) {
                System.out.println("\n\t\tFile not found.... Sorry we are Closing Program\n");
                System.exit(1);
            }catch(IndexOutOfBoundsException e) {
                System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                System.exit(1);
            }
            System.out.println();
            System.out.println("\n\t\t\t\t**********************************************");
            System.out.println("\t\t\t\t  Username and Password successfully updated");
            System.out.print("\t\t\t\t**********************************************\n");
            System.out.println("_________________________________________________________________________________________________________\n\n");
            login(Members, trainer, AdminInfo, Machines);//...Line 148...
        }
        else
            System.exit(1);
        System.out.println("\n\n_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tAdmin Details");
        System.out.println(" Admin Name : " + " Mr.Haris Awaan");
        System.out.println("\n GYM Timings: ");
        System.out.println("Morning Time: " +  5 + "am - " + 11 + "am");
        System.out.println("Evening Time: " +  4 + "pm - " + 11 + "pm");
        System.out.println("_________________________________________________________________________________________________________");

        mainmenu(Members, trainer, AdminInfo, Machines);
    }
    //...................................................Main Menu Method..................................................
    public static void mainmenu (String[][] Members, String[][] trainer, String[] AdminInfo, String[][] Machines) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n\t\t\t\t\t***************");
            System.out.println("\t\t\t\t\t** MAIN MENU **");
            System.out.println("\t\t\t\t\t***************\n");
            System.out.println("1. Member");//...Line 323...
            System.out.println("2. Trainer");//...Line 374...
            System.out.println("3. Machines");//...Line 426...
            System.out.println("4. Machine Booking");//...Line 476...
            System.out.println("0. Logout");
            System.out.println("00.Exit");
            System.out.print("\nEnter Your Choice: ");
            String cho = sc.next();
            while (true){
                if (cho.equals("1") || cho.equals("2") || cho.equals("3") || cho.equals("4") || cho.equals("0") || cho.equals("00"))
                    break;
                else{
                    System.out.println("\n\t\tInvalid Choice.....Please Choose between 0-4 or 00 \n");
                    System.out.print("Enter Your Choice: ");
                    cho = sc.next();
                }
            }
            if (cho.equals("00")){
                System.exit(1);
            }
            else if (cho.equals("0"))	{
                System.out.println("\n");
                System.out.println("\t\t\t\t\t****************");
                System.out.println("\t\t\t\t\t     LOGOUT     ");
                System.out.println("\t\t\t\t\t Have a nice Day");
                System.out.println("\t\t\t\t\t****************\n\n\n");
                login(Members, trainer, AdminInfo, Machines);//...Line 148...
                break;
            }
//...........................................................................................................Members...
            else if (cho.equals("1")){
                while(true){
                    System.out.println("\n\t\t\t\t\t***************");
                    System.out.println("\t\t\t\t\t*** OPTIONS ***");
                    System.out.println("\t\t\t\t\t***************\n\n");
                    System.out.println("1- Details of Members");
                    System.out.println("2- View All Members");
                    System.out.println("3- Modify Members");
                    System.out.println("4- Add new Member");
                    System.out.println("5- Delete Member");
                    System.out.println("6- Back To Main Menu");
                    System.out.print("Enter choice from (1 - 6): ");
                    String choic = sc.next();
                    if (choic.equals("1"))
                        DetailsOfMember(Members, trainer, AdminInfo, Machines);//...Line 540...
                    else if (choic.equals("2"))
                        View_Members(Members);//...Line 589...
                    else if (choic.equals("3"))	{
                        modify_Members(Members, trainer, AdminInfo, Machines);//...Line 603...
                    } else if (choic.equals("4")) {
                        add_new_members(Members, trainer, AdminInfo, Machines);//...Line 798...
                        //Modify the file Members(Store from 2d Member Array to File)..............
                        try{
                            PrintWriter myFile = new PrintWriter("./Members.txt");
                            for(int i = 0;i<Members.length;i++) {
                                for(int j = 0 ; j < Members[0].length ; j++) {
                                    myFile.print(Members[i][j]+"#");
                                }
                                myFile.println();
                            }
                            myFile.close();
                        }catch(FileNotFoundException e) {
                            System.out.println("\n\t\tFile not found.... Sorry we are Closing Program\n");
                            System.exit(1);
                        }catch(IndexOutOfBoundsException e) {
                            System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                            System.exit(1);
                        }
                    } else if(choic.equals("5"))
                        delete_Members(Members);//...Line 1046...
                    else if (choic.equals("6"))	{
                        mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288....
                        break;
                    }
                    else {
                        System.out.println();
                        System.out.println("\n\t\t\t\tWrong Choice! Select choice from (1-6)");
                    }
                }
            }
//..........................................................................................................Trainers...
            else if (cho.equals("2")){
                while(true){
                    System.out.println();
                    System.out.println("\t\t\t\t\t***************");
                    System.out.println("\t\t\t\t\t*** OPTIONS ***");
                    System.out.println("\t\t\t\t\t***************");
                    System.out.println("\n1- View All Trainers");
                    System.out.println("2- Detail of Trainer");
                    System.out.println("3- Add Trainer");
                    System.out.println("4- Modify Trainer");
                    System.out.println("5- Delete Trainer");
                    System.out.println("6- Back to Main Menu");
                    System.out.print("Enter choice from(1 - 6): ");
                    String choic = sc.next();
                    if(choic.equals("1"))
                        View_Trainers(trainer);//...Line 1109...
                    else if (choic.equals("2"))
                        Trainers_detail(Members, trainer, AdminInfo, Machines);//...Line 1124...
                    else if (choic.equals("3")) {
                        Add_Trainer(trainer);//...Line 1167...
                        //Modify the Trainers' File (Store from 2d Trainer Array to File)....
                        try{  PrintWriter myFile = new PrintWriter("./trainers.txt");
                            for(int i = 0;i<trainer.length;i++) {
                                for(int j = 0 ; j < trainer[0].length ; j++) {
                                    myFile.print(trainer[i][j]+"#");
                                }
                                myFile.println();
                            }
                            myFile.close();
                        }catch(FileNotFoundException e) {
                            System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program.");
                            System.exit(1);
                        }catch(IndexOutOfBoundsException e) {
                            System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program.");
                            System.exit(1);
                        }
                    }else if(choic.equals("4")){
                        Modify_trainer(Members, trainer, AdminInfo, Machines);//...Line 1221...
                    }else if(choic.equals("5")) {
                        delete_Trainers(Members, trainer, AdminInfo, Machines);//...Line 1315...
                    }
                    else if (choic.equals("6"))	{
                        mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288...
                        break;
                    }
                    else {
                        System.out.println();
                        System.out.println("\n\t\t\t\tWrong Choice! Choice should be from (1-6)");
                    }
                }
            }
//..........................................................................................................Machines...
            else if (cho.equals("3"))	{
                while(true){
                    System.out.println();
                    System.out.println("\n\t\t\t\t\t***************");
                    System.out.println("\t\t\t\t\t*** OPTIONS ***");
                    System.out.println("\t\t\t\t\t***************\n");
                    System.out.println("1- Details of a Machine");
                    System.out.println("2- View All Machines");
                    System.out.println("3- Add new Machine");
                    System.out.println("4- Delete Machine");
                    System.out.println("5- Back to Main Menu");
                    System.out.print("Enter choice from(1 - 5): ");
                    String choic = sc.next();
                    if (choic.equals("1"))
                        DetailsOfMachines(Members, trainer, AdminInfo, Machines);//...Line 1378...
                    else if (choic.equals("2"))
                        View_Machines(Machines);//...Line 1412...
                    else if (choic.equals("3")) {
                        add_new_machines(Machines);//...Line 1425...
                        //Modify the file Machines(Store from 2d Machine Array to File)
                        try{
                            PrintWriter myFile = new PrintWriter("./Machines.txt");
                            for(int i = 0;i<Machines.length;i++) {
                                for(int j = 0 ; j < Machines[0].length ; j++) {
                                    myFile.print(Machines[i][j]+"#");
                                }
                                myFile.println();
                            }
                            myFile.close();
                        }catch(FileNotFoundException e) {
                            System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program");
                            System.exit(1);
                        }catch(IndexOutOfBoundsException e) {
                            System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program");
                            System.exit(1);
                        }
                    }
                    else if(choic.equals("4"))
                        delete_Machines(Machines);//...Line 1503...
                    else if (choic.equals("5"))	{
                        mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288...
                        break;
                    }
                    else {
                        System.out.println();
                        System.out.println("\n\t\t\t\tWrong Choice! Choice should be from (1-5)");
                    }
                }
            }
//...........................................................................................................Booking...
            else if (cho.equals("4"))	{
                while(true)	{
                    System.out.println("\n\n\t\t\t\t\t***************");
                    System.out.println("\t\t\t\t\t*** OPTIONS ***");
                    System.out.println("\t\t\t\t\t***************\n");
                    System.out.println("_________________________________________________________________________________________________________");
                    System.out.println();
                    System.out.println("Note:\n  Before You Start Booking For New Day. Please reset the Booking Information of Previous days\n");
                    System.out.println("_________________________________________________________________________________________________________\n\n");
                    System.out.println("1. Book a machine ");
                    System.out.println("2. Cancel Booking ");
                    System.out.println("3. Booking Details");
                    System.out.println("4. Morning Time Reservations ");
                    System.out.println("5. Evening Time Reservations ");
                    System.out.println("6. Reset Reservations ");
                    System.out.println("7. Back to Main Menu ");
                    System.out.print("\nEnter choice from(1-7): ");
                    String choic = sc.next();
                    while(true)	{
                        if (!(choic.equals("1") || choic.equals("2") || choic.equals("3") || choic.equals("4")
                                || choic.equals("5") || choic.equals("6") || choic.equals("7")))	{
                            System.out.println("\n\t\t\t\tWrong Choice! Select choice from (1-7)\n");
                            System.out.print("Enter Choice (1-7): ");
                            choic = sc.next();	}
                        else break;	}
                    if (choic.equals("1"))   {
                        bookMachine(Members, trainer, AdminInfo, Machines);//...Line 1567...
                    }
                    else if (choic.equals("2"))	{
                        cancelBooking(Members, trainer, AdminInfo, Machines);//...Line 1805...
                    }
                    else if (choic.equals("3"))  {
                        bookingDetail(Members, trainer, AdminInfo, Machines);   }//...Line 1996...
                    else if (choic.equals("4"))  {
                        morningBookingInfo(Members, Machines);   }//...Line 2053...
                    else if (choic.equals("5"))  {
                        eveningBookingInfo(Members, Machines);   }//...Line 2084...
                    else if (choic.equals("6"))  {
                        resetBooking(Members, trainer, AdminInfo, Machines);//...Line 2115...
                        //Modify the file Machines(Store from 2d Machines Array to File)
                        try{  PrintWriter myFile1 = new PrintWriter("./Machines.txt");
                            for(int i = 0;i<Machines.length;i++) {
                                for(int j = 0 ; j < Machines[0].length ; j++) {
                                    myFile1.print(Machines[i][j]+"#");
                                }
                                myFile1.println();
                            }
                            myFile1.close();
                        }catch(FileNotFoundException e) {
                            System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program\n");
                            System.exit(1);
                        }catch(IndexOutOfBoundsException e) {
                            System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                            System.exit(1);
                        }
                    }
                    else if (choic.equals("7"))  {
                        mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288...
                        break; }
                }
            }
        }
    }
    //..................................................Method to Show Details of a Member.................................
    public static void DetailsOfMember(String[][] Members, String[][] trainer, String[] AdminInfo, String[][] Machines) throws IOException {
        System.out.println("\n"+"_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tDetails Of Members \n\n");
        int index = -1;
        String No;
        System.out.println("Enter registration Number: ");
        System.out.println("OR 'Y' for Main Menu");
        do{
            Scanner input = new Scanner(System.in);
            No = input.next();
            No = validate_regNo(No, Members, trainer, AdminInfo, Machines);//...Line 2231...
            for(int i = 0; i < Members.length; i++){
                if(No.equals(Members[i][0])){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                System.out.println("\n_________________________________________________________________________________________________________");
                System.out.println();
                System.out.println("\t\t\t\t\t* Data of "+Members[index][1]+" *");
                System.out.println("_________________________________________________________________________________________________________\n");
                System.out.println("\n-> Registration Number: " + Members[index][0]);
                System.out.println("\n-> First Name: " + Members[index][1]);
                System.out.println("\n-> Last Name: " + Members[index][2]);
                System.out.println("\n-> Date Of Birth: " + Members[index][3]);
                System.out.println("\n-> Gender: " + Members[index][4]);
                System.out.println("\n-> Weight: " + Members[index][5]+" KG");
                System.out.println("\n-> Height: " + Members[index][6]+" Ft");
                System.out.println("\n-> Fitness Program: " + Members[index][7]);
                System.out.println("\n-> Contact Number: " + Members[index][8]);
                int cnt = 0;
                for (int i = 0; i< 20; i++){
                    if (Members[index][9].equals(trainer[i][0])){
                        cnt++;
                        System.out.println("\n-> Trainer: " + trainer[i][1]);
                        break;
                    }
                }if(cnt==0){System.out.println("\n-> Trainer: " + "No Trainer......"); }
                System.out.println("\n-> Workout Session: " + Members[index][10]);
                System.out.println("\n-> MemberShip: " + Members[index][11]);
                System.out.println("_________________________________________________________________________________________________________");
            }
            else{
                System.out.print("\n\t\tMember not found. Enter 'Y' for main menu or Again enter registration number for details:  \n\n");
            }
        }while(index == -1);
    }
    //................................................Method to View All Members...........................................
    public static void View_Members(String[][] list) {
        int d = 0;
        System.out.println("\n_________________________________________________________________________________________________________");
        System.out.println("   Reg. No.       "+" |   "+ " Sessions     " + "  |        Names");
        System.out.println("___________________|___________________|_________________________________________________________________");
        for (int i = 0; i < list.length; i++) {
            if (list[i][0].equals("null") == false) {
                d++;
                System.out.printf("%-3d %-15s| \t%-15s|\t%s %s\n",d,list[i][0],list[i][10],list[i][1],list[i][2]);
            }
        }
        System.out.println("___________________|___________________|_________________________________________________________________\n");
    }
    //...........................................Method to Modify The Members..........................................
    public static void modify_Members(String list[][], String list2[][], String list3[], String list4[][]) throws IOException {
        System.out.println("\n_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tModify Members");
        int index;
        System.out.print("\nEnter Registration Number: ");
        do{
            Scanner input = new Scanner(System.in);
            String Reg_No = input.next();
            Reg_No = validate_regNo(Reg_No, list, list2, list3, list4);//...Line 2231...
            index = -1;
            for (int i = 0; i < list.length; i++){//Finding index of the row where Reg No. Matches....
                if (Reg_No.equals(list[i][0]) == true) {
                    System.out.println("\n_________________________________________________________________________________________________________\n");
                    System.out.println("\t\t\t\t* Modify the Details of "+list[i][1]+" "+ list[i][2]+" *");
                    index = i;
                    break;
                }
            }
            if(index != -1){
                System.out.println("\nWhat do you want to modify: ");
                while(true)	{
                    System.out.println("1- Name! ");
                    System.out.println("2- Last Name! ");
                    System.out.println("3- Weight! ");
                    System.out.println("4- Height! ");
                    System.out.println("5- Trainer! ");
                    System.out.println("6- Contact Number! ");
                    System.out.println("7- Program! ");
                    System.out.println("8- Session! ");
                    System.out.println("Y- Main Menu");
                    System.out.print("Enter choice from (1-8) or 'Y' for Main Menu: ");
                    String choic = input.next();
                    if (choic.equalsIgnoreCase("y")){
                        mainmenu(list, list2, list3, list4 );//...Line 288...
                        break;
                    }
                    while (true){
                        if (!(choic.equals("1") || choic.equals("2") || choic.equals("3") || choic.equals("4") || choic.equals("5") || choic.equals("6") || choic.equals("7")  || choic.equals("8"))) {
                            System.out.print("\n\t\t\t\tInvalid choice. Choose between 1-8 or Y: ");
                            choic = input.next();
                            if (choic.equalsIgnoreCase("y")){
                                mainmenu(list, list2, list3, list4);//...Line 288...
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    if(choic.equals("1")) {
                        System.out.print("\nEnter Name: ");
                        String buffereater = input.nextLine();
                        String name = input.nextLine();
                        list[index][1] = validate_name(name);//...Line 2171...
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tName Updated Successfully! \n\n");
                    }
                    else if(choic.equals("2")) {
                        System.out.print("\nEnter Last Name: ");
                        String buffereater = input.nextLine();
                        String l_name = input.nextLine();
                        list[index][2] = validate_name(l_name);//...Line 2171...
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tLast Name Updated Successfully! \n\n");
                    }
                    else if (choic.equals("3")) {
                        int colunm = 5;
                        InputforHeightAndWeight(list,choic,index,colunm);//...Line 2261...
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tWeight Updated Successfully! \n\n");
                    }else if (choic.equals("4")) {
                        int colunm = 6;
                        InputforHeightAndWeight(list,choic,index,colunm);//...Line 2261...
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tHeight Updated Successfully! \n\n");
                    }else if (choic.equals("5")) {
                        System.out.println("\n\nTrainers Details are as Follows! ");
                        int j = 1;
                        //To print list of trainers available
                        for (int i = 0; i < list2.length; i++) {
                            if (list2[i][0].equals("null") != true) {
                                System.out.printf("%2d",j);
                                System.out.println(". "+list2[i][0] + " "+list2[i][1]);
                                j++;}
                        }
                        System.out.print("\nEnter registration number of trainer you want: ");
                        String buffereater = input.nextLine();
                        String trainer = input.nextLine();
                        trainer = validate_regNo(trainer,list,list2,list3,list4);//...Line 2231...
                        boolean loop = true;
                        int indii;
                        while(loop){
                            for (int i = 0; i < list2.length; i++){
                                if (trainer.equalsIgnoreCase(list2[i][0])){
                                    list[index][9] =trainer;
                                    loop = false;
                                    indii = i;
                                    break;
                                }
                            }if (loop)
                            {
                                System.out.println("\n\t\t\t\tInvalid.....Please enter correct Registration number ");
                                trainer = input.nextLine();
                                trainer = validate_regNo(trainer,list,list2,list3,list4);//...Line 2231...
                            }
                        }
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tTrainer Updated Successfully! \n\n");
                    }else if (choic.equals("6")) {
                        System.out.print("\nEnter contact Number (03XX-XXXXXXX): ");
                        String contact_num = input.next();
                        list[index][8] = validate_phone(contact_num);//...Line 2198...
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tContact Number Updated Successfully! \n\n");
                    }else if (choic.equals("7")) {
                        System.out.println("\nSelect your fitness Program");
                        System.out.println("1- Weight Loss");
                        System.out.println("2- Muscle Gain");
                        System.out.println("3- Shredding");
                        System.out.print("Enter Your Choice: ");
                        String choice2 = input.next();
                        while(choice2.equals("1") == false && choice2.equals("2") == false && choice2.equals("3") == false) {
                            System.out.println("\n\t\t\t\tWrong choice! Please Select Valid Choice\n");
                            System.out.println("Select choice from 1-3");
                            choice2 = input.next();
                        }
                        if(choice2.equals("1")) {
                            list[index][7] = "Weight Loss";
                        }
                        if(choice2.equals("2")) {
                            list[index][7] = "Muscle Gain";
                        }
                        if(choice2.equals("3")) {
                            list[index][7] = "Shredding";
                        }
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tFitness Program Updated Successfully! \n\n");
                    }else if (choic.equals("8")) {
                        System.out.println("\nSelect Workout Session : ");
                        System.out.println("1- Morning");
                        System.out.println("2- Evening");
                        System.out.print("Enter Your Choice: ");
                        String ch = input.next();
                        while (ch.equals("1") == false && ch.equals("2") == false) {
                            System.out.print("\n\t\t\t\tInvalid choice. Choose between 1-2: ");
                            ch = input.next();
                        }
                        if(ch.equals("1")) {
                            list[index][10] = "Morning";
                        }
                        else if(ch.equals("2")) {
                            list[index][10] = "Evening";
                        }
                        System.out.println("_________________________________________________________________________________________________________");
                        System.out.println("\t\t\t\tWorkout Session Updated Successfully! \n\n");
                    }

                    //Modify the file Members(Store from 2d Member Array to File)
                    try{
                        PrintWriter myFile = new PrintWriter("./Members.txt");
                        for(int i = 0;i<list.length;i++) {
                            for(int j = 0 ; j < list[0].length ; j++) {
                                myFile.print(list[i][j]+"#");
                            }
                            myFile.println();
                        }
                        myFile.close();
                    }catch(FileNotFoundException e) {
                        System.out.println("\n\t\tFile not found.... Sorry we are Closing Program\n");
                        System.exit(1);
                    }catch(IndexOutOfBoundsException e) {
                        System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                        System.exit(1);
                    }
                    System.out.println("\n\t\t\tWould you like to modify anything else Y/N ?");
                    String x1 = input.next();
                    while(true){
                        if (x1.equalsIgnoreCase("Y") || x1.equalsIgnoreCase("N"))	{
                            break;		}
                        else	{
                            System.out.println("\n\t\t\t\t\tInvalid. Choice must be Y/N");
                            x1 = input.next();}
                    }
                    if (x1.equalsIgnoreCase("n"))
                        break;
                    else
                        System.out.println("\nWhat do you want to modify: ");
                }
            }
            if (index == -1)
                System.out.print("\n\t\tMember Not FOUND. Enter 'Y' for Main Menu or Enter registration number Again: \n");
        }while(index == -1);
        System.out.println("_________________________________________________________________________________________________________");
    }
    //................................................Method to Add New Member.............................................
    public static String[][] add_new_members(String[][] list1, String list2[][], String list3[], String list4[][]) throws IOException {
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tAdding New Member\n\n");
        Scanner input = new Scanner(System.in);
        int index = -1;
        for(int i = 0; i < list1.length; i++) {
            if (list1[i][0].equals("null")) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("\n\t\t\t\tSorry, No Membership available.");
        }
        if(index != -1)	{
            System.out.print("\n\t\tRegistration Number is ==> ");
            String regNo = String.valueOf((int)(1000 + Math.random() * 1100));
            for (int i = 0; i < list1.length; i++) {
                while (list1[i][0].equals(regNo)) {
                    regNo = String.valueOf((int)(1000 + Math.random() * 1100));
                }
            }
            System.out.println(regNo + "\n");
            list1[index][0] = regNo;
            System.out.print("Enter the first name of Member: ");
            String firstName = input.nextLine();
            list1[index][1] = validate_name(firstName);//...Line 2171...
            System.out.print("\nEnter the last name of Member: ");
            String lastName = input.nextLine();
            list1[index][2] = validate_name(lastName);//...Line 2171...
            System.out.print("\nEnter Date Of Birth (DD/MM/YYYY): ");
            String dateOfBirth;
            int date;
            int month;
            int year;
            int count;
            //Validation for Maintaining Format (DD/MM/YYYY) in Input....................
            while(true)	{
                dateOfBirth = input.next();
                if (!(dateOfBirth.length() == 10 && dateOfBirth.charAt(2) == '/' && dateOfBirth.charAt(5) == '/'))	{
                    System.out.println("\n\t\t\t\tIt appears that you entered the wrong format.Please enter as (DD/MM/YYYY) ");
                    continue;
                }
                else	{
                    count = 0;
                    for(int i =0; i < dateOfBirth.length(); i++)	{
                        if (!(Character.isDigit(dateOfBirth.charAt(i))))	{
                            if (i == 2 || i == 5)	{
                                continue;	}
                            System.out.println("\n\t\t\t\tIt appears that you entered the wrong format.Please enter only digits ");
                            count++;
                            break;	}
                    }
                    if (count != 0)	{
                        continue;	}
                }
                date = Integer.parseInt(dateOfBirth.substring(0,2));
                month = Integer.parseInt(dateOfBirth.substring(3,5));
                year = Integer.parseInt(dateOfBirth.substring(6,10));
                //Controlling Values be normal...........................................
                if ((year % 400 == 0 ) || ((year % 4 == 0) && (year % 100 !=0))){
                    if (month == 2){
                        if (date > 29 || date <= 0)	{
                            System.out.println("\n\t\t\t\tIt appears that you entered the wrong date for Month (" + month + "),Try again ");
                            continue;		}
                    }
                }
                else{
                    if (month == 2){
                        if (date > 28 || date <= 0)	{
                            System.out.println("\n\t\t\t\tIt appears that you entered the wrong date for Month (" + month + "),Try again ");
                            continue;		}
                    }
                }

                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                    if (date > 31 || date <= 0)	{
                        System.out.println("\n\t\t\t\tIt appears that you entered the wrong date for Month (" + month + "),Try again ");
                        continue;		}
                }
                if (month == 4 || month == 6 || month == 9 || month == 11)	{
                    if (date > 30 || date <= 0)	{
                        System.out.println("\n\t\t\t\tIt appears that you entered the wrong date for Month (" + month + "),Try again ");
                        continue;		}
                }
                if (month > 12 || month <= 0)	{
                    System.out.println("\n\t\t\t\tIt appears that you entered the wrong month in Date of birth,Try again ");
                    continue;	}
                if (year > 2018 || year < 1922)	{
                    System.out.println("\n\t\t\t\tIt appears that you entered the wrong year in Date of birth,Try again ");
                    continue;	}
                break;
            }
            list1[index][3] = dateOfBirth;
            System.out.println("\n\nSelect Gender ");
            System.out.println("1- Male");
            System.out.println("2- Female");
            System.out.println("3- Other");
            String choice = input.next();
            while (choice.equals("1") == false && choice.equals("2") == false && choice.equals("3") == false) {
                System.out.println("\n\t\t\t\tWrong choice! Please select valid choice\n");
                System.out.print("Select choice from 1-3: ");
                choice = input.next();
            }
            if(choice.equals("1") == true) {
                list1[index][4] = "Male";
            }
            else if(choice.equals("2") == true) {
                list1[index][4] = "Female";
            }
            else{
                list1[index][4] = "Other";
            }
            int colunm = 5;
            String choiceforWeight = "3";
            InputforHeightAndWeight(list1,choiceforWeight,index,colunm);//...Line 2261...
            colunm = 6;
            String choiceforHeight = "4";
            InputforHeightAndWeight(list1,choiceforHeight,index,colunm);//...Line 2261...
            System.out.println("\nSelect your fitness Program");
            System.out.println("1- Weight Loss");
            System.out.println("2- Muscle Gain");
            System.out.println("3- Shredding");
            System.out.print("Enter the choice(1-3): ");
            String choice2 = input.next();
            while (choice2.equals("1") == false && choice2.equals("2") == false && choice2.equals("3") == false) {
                System.out.println("\n\t\t\t\tWrong choice! Please Select Valid Choice\n");
                System.out.print("Select choice from 1-3: ");
                choice2 = input.next();
            }
            if(choice2.equals("1")) {
                list1[index][7] = "Weight Loss";
            }
            else if(choice2.equals("2")) {
                list1[index][7] = "Muscle Gain";
            }
            else{
                list1[index][7] = "Shredding";
            }
            System.out.print("\nEnter Contact Number (Format ==> 03XX-XXXXXXX): ");
            String Phone = input.next();
            list1[index][8] = validate_phone(Phone);//...Line 2198...
            System.out.println("\n\nNeed Trainer! ");
            System.out.print("Press 'Y' for Yes and 'N' for No: ");
            String c = input.next();
            while(true){
                if (c.equalsIgnoreCase("Y") || c.equalsIgnoreCase("N"))
                    break;
                else	{
                    System.out.println("\n\t\t\t\tInvalid. Choice must be Y/N \n");
                    System.out.print("Enter choice as 'Y' or 'N': ");
                    c = input.next();}
            }
            if(c.equalsIgnoreCase("Y")) {
                System.out.println("\n\nFollowing Trainers are Available: \n");
                for(int i = 0; i < list2.length; i++) {
                    if(!(list2[i][0].equals("null")))
                        System.out.println("-> "+list2[i][0] + " "+list2[i][1]);
                }
                String trainer_name;
                boolean n = true;
                String buffereater = input.nextLine();
                while(n){
                    System.out.print("\nEnter Registration number of Trainer from list You want: ");
                    trainer_name = input.nextLine();
                    trainer_name = validate_regNo(trainer_name,list1,list2,list3,list4);//...Line 2231...
                    for(int i = 0; i < list2.length; i++) {
                        if(trainer_name.equalsIgnoreCase(list2[i][0])) {
                            list1[index][9] = trainer_name;
                            n = false;
                            break;
                        }
                    }
                }
            }
            else{
                list1[index][9] = "None";}
            System.out.println("\nSelect Workout Session : ");
            System.out.println("1- Morning");
            System.out.println("2- Evening");
            System.out.print("Enter the choice(1-2): ");
            String ch = input.next();
            while (ch.equals("1") == false && ch.equals("2") == false) {
                System.out.println("\n\t\t\t\tInvalid choice. Please Select the valid choice \n");
                System.out.print("Select the choice(1-2): ");
                ch = input.next();
            }
            if(ch.equals("1")) {
                list1[index][10] = "Morning";
            }
            else if(ch.equals("2")) {
                list1[index][10] = "Evening";
            }
            System.out.println();
            System.out.println("\n\tSelect Your MemberShip: \n");
            if(c.equalsIgnoreCase("N")) {
                System.out.println("MemberShip Rates without Trainer");
                System.out.println("1- One Year (50,000PKR)");
                System.out.println("2- Six Month (25,000PKR)");
                System.out.println("3- Three Month (12,000PKR)");
                System.out.println("4- One Month (5,000PKR)");
                System.out.print("Select Your Choice: ");
                String choice1 = input.next();
                while(choice1.equals("1") == false && choice1.equals("2") == false && choice1.equals("3") == false && choice1.equals("4") == false) {
                    System.out.println("\n\t\t\t\tInvalid choice. Please Select the valid choice \n");
                    System.out.print("Select the choice(1-4): ");
                    choice1 = input.next();
                }
                if(choice1.equals("1")) {
                    list1[index][11] = "One Year (50,000PKR)";
                }else if (choice1.equals("2")) {
                    list1[index][11] = "Six Month (25,000PKR)";
                }else if (choice1.equals("3")) {
                    list1[index][11] = "Three Month (12,000PKR)";
                }else{
                    list1[index][11] = "One Month (5,000PKR)";
                }
            }
            if(c.equalsIgnoreCase("Y")) {
                System.out.println("MemberShip Rates with Trainer " + list1[index][9]);
                System.out.println("1- One Year (80,000PKR)");
                System.out.println("2- Six Month (40,000PKR)");
                System.out.println("3- Three Month (20,000PKR)");
                System.out.println("4- One Month (10,000PKR)");
                System.out.print("Select Your Choice: ");
                String ch2 = input.next();
                while (ch2.equals("1") == false && ch2.equals("2") == false && ch2.equals("3") == false && ch2.equals("4") == false) {
                    System.out.println("\n\t\t\t\tInvalid choice. Please Select the valid choice \n");
                    System.out.print("Select the choice(1-4): ");
                    ch2 = input.next();
                }
                if(ch2.equals("1")) {
                    list1[index][11] = "One Year (80,000PKR)";
                }else if (ch2.equals("2")) {
                    list1[index][11] = "Six Month (40,000PKR)";
                }else if (ch2.equals("3")) {
                    list1[index][11] = "Three Month (20,000PKR)";
                }else {
                    list1[index][11] = "One Month (10,000PKR)";
                }
            }
            System.out.println("\n");
            System.out.println("\t\t\t\tMember Added Successfully");
            System.out.println("_________________________________________________________________________________________________________");
        }
        return list1;
    }
    //.......................................Method to Delete Members......................................................
    public static void delete_Members(String list[][]) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nEnter the RegNo to delete the Member: ");
        String str = input.nextLine();
        boolean y = true;
        while(y){
            if (str.equalsIgnoreCase("null")){
                System.out.print("\n\n\t\t\t\tYou Have entered Wrong RegNo.\nEnter Correct Reg NO. : ");
                str = input.nextLine();
            }else{y = false;}
        }
        File myFile = new File("Members.txt");
        Scanner sc = new Scanner(myFile);
        boolean x = false;
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            if (s.startsWith(str)){
                x = true;
                System.out.print("\nMember found\nDo you want to Delete (Y/N): ");
                boolean loop = true;
                while(loop){
                    String choice = input.next();
                    if (choice.equalsIgnoreCase("Y")){
                        break;
                    }
                    else if (choice.equalsIgnoreCase("N")){
                        loop = false;
                        return;} //nothing return..............................
                    else
                        System.out.println("\n\t\t\t\tIncorrect Choice.Enter 'Y' or 'N' ");
                }
            }
        }if(x == false){
            System.out.println("Member not found\n");
            return;
        }sc.close();
        Scanner scan = new Scanner(myFile);
        String data = "";
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            if (line.startsWith(str))
                data +=  "null#null#null#null#null#null#null#null#null#null#null#null#\n";
            else
                data += line+"\n";
        }
        scan.close();
        myFile.delete();//delete previous file...........................................................
        File myNewFile = new File("./Members.txt");//create new file with the same name.............................................
        FileWriter writer = new FileWriter(myNewFile);
        writer.write(data); //write data from data(String) into Members' New file............................
        writer.close();
        System.out.println("\n\t\t\t\tMembership removed successfully");
        File a1 = new File("Members.txt");
        Scanner inp = new Scanner(a1);
        //Storing data from file to Members 2d Array.....................................
        for(int i = 0; i < list.length; i++){
            String ab = inp.nextLine();
            String[] dta = ab.split("#");
            for(int j = 0; j < list[0].length; j++){
                list[i][j] = dta[j];}
        }System.out.println("_________________________________________________________________________________________________________\n");
    }
    //.............................................Method To View All Trainers.............................................
    public static void View_Trainers(String[][] list) {
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("No."+ "\tReg. No.\tNames");
        System.out.println("_________________________________________________________________________________________________________");
        int j = 1;
        for(int i = 0; i < list.length; i++) {
            if(list[i][0].equals("null") == false) {
                // j used for numbering Only................
                System.out.println((j)+".\t"+list[i][0]+" \t\t"	+list[i][1]);
                j++;
            }
        }
        System.out.println("_________________________________________________________________________________________________________\n");
    }
    //.............................................Method For Details of a Trainer.........................................
    public static void Trainers_detail(String list1[][], String[][] list, String[]list3, String[][] list4) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tTrainers' Details");
        int index;
        System.out.print("\n\nEnter registration number of trainer or 'Y' to return : ");
        do {
            String name = sc.nextLine();
            name = validate_regNo(name,list1,list,list3,list4);//...Line 2231...
            if(name.equalsIgnoreCase("y"))	{
                mainmenu(list1, list, list3, list4);//...Line 288...
                break;	}
            index = -1;
            for (int i = 0; i < list.length; i++) {
                if (name.equalsIgnoreCase(list[i][0])) {
                    index = i;
                    break;}
            }
            if(index != -1) {
                System.out.println("\n_________________________________________________________________________________________________________");
                System.out.println("\t\t\t\t\tDetails of "+list[index][1]);
                System.out.println("\n-> Reg. No: " + list[index][0]);
                System.out.println("-> Trainer's Name: " + list[index][1]);
                System.out.println("-> Gender: " + list[index][2]);
                System.out.println("-> Contact Number: " + list[index][3]);
                System.out.println("-> Members:");
                int a = 0;
                for(int i = 0; i < list1.length; i++)	{
                    if (list[index][0].equals(list1[i][9]))	{
                        a++;
                        System.out.println("   " + a + "-" + list1[i][1] + " " + list1[i][2]);
                    }
                }
                if (a == 0)
                    System.out.println("   Trainer has No Members....");
            }
            else{
                System.out.println("\n\t\t\tSorry! Trainer not Found.Enter RegNo. again or Y for Main Menu ");
            }
        } while( index == -1);
        System.out.println("_________________________________________________________________________________________________________");
    }
    //.............................................Method to Add Trainers..................................................
    public static String [][] Add_Trainer(String[][] list) {
        Scanner input = new Scanner(System.in);
        int index = -1;
        for(int i = 0; i < list.length; i++) {
            if(list[i][0].equals("null") == true) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("\n\t\t\t\tSorry, there is No available Vacancy");
        }
        if(index != -1) {
            System.out.print("\n\n\t\tRegistration Number is ");
            String regNo = String.valueOf((int)(1000 + Math.random() * 1100));
            for (int i = 0; i < list.length; i++) {
                while (list[i][0].equals(regNo)) {
                    regNo = String.valueOf((int)(1000 + Math.random() * 1100));
                }
            }
            System.out.println(regNo);
            list[index][0] = regNo;
            System.out.print("\nEnter the name of Trainer: ");
            String name = input.nextLine();
            list[index][1] = validate_name(name);//...Line 2171...
            System.out.println("\nSelect gender: ");
            System.out.println("1- Male");
            System.out.println("2- Female");
            System.out.println("3- Others");
            System.out.print("Enter Choice(1-3): ");
            String choice = input.next();
            while(!(choice.equals("1") || choice.equals("2") || choice.equals("3"))){
                System.out.println("\n\t\t\t\tWrong Choice! Please enter valid choice");
                System.out.print("\nEnter Choice (1-3): ");
                choice = input.next();
            }
            if(choice.equals("1")){
                list[index][2] = "Male";
            }
            else if(choice.equals("2")){
                list[index][2] = "Female";
            }
            else{
                list[index][2] = "Other";
            }
            System.out.print("\nEnter contact Number: ");
            String C_no = input.next();
            list[index][3] = validate_phone(C_no);//...Line 2198...
            System.out.println("\n\t\t\t\t Trainer Added Successfully");
            System.out.println("_________________________________________________________________________________________________________\n");
        }
        return list;
    }
    //..................................................Method to Modify Trainers..........................................
    public static void Modify_trainer(String[][]list1, String[][]list, String[] list3, String[][] list4) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nTrainers' names are as follows");
        for(int i = 0;i<list.length;i++){
            if(!(list[i][0].equals("null"))){
                System.out.println("-> "+list[i][0]+"  "+list[i][1]);
            }
        }
        String trainer_name;
        boolean n = true;
        int index = 1;
        int skip = 0;
        while(n){
            System.out.print("\nEnter Registration number of trainer You want to Modify \n(or 'Y' for Main Menu): ");
            trainer_name = input.nextLine();
            trainer_name = validate_regNo(trainer_name,list1,list,list3,list4);//...Line 2231...
            if(trainer_name.equalsIgnoreCase("y"))	{
                mainmenu(list1, list, list3, list4);//...Line 288...
                skip = 1;
                break;	}
            for (int j = 0; j < list.length; j++) {
                if(trainer_name.equals(list[j][0])) {
                    index = j;
                    n = false;}
            }
        }
        if(skip != 1){
            while (true)	{
                System.out.println("\n\nWhat do you want to modify");
                System.out.println("1- Name");
                System.out.println("2- Contact Number");
                System.out.print("Enter Your Choice (1-2):");
                String choice = input.next();
                String buffereater = input.nextLine();
                while(!(choice.equals("1") || choice.equals("2"))){
                    System.out.println("\n\t\t\t\tWrong Choice! Please enter valid choice or 'Y' for Main Menu ");
                    System.out.print("\nSelect from (1-2 or Y for main menu): ");
                    choice = input.next();
                    input.nextLine();
                    if(choice.equalsIgnoreCase("y"))	{
                        mainmenu(list1, list, list3, list4);//...Line 288...
                        break;	}
                }
                if(choice.equals("1")){
                    System.out.print("\n\nEnter Trainer's Name: ");
                    String f_name = input.nextLine();
                    list[index][1] = validate_name(f_name);//...Line 2171...
                    System.out.println("\n\n\n\t\t\t\t\tName Updated Successfully");
                    System.out.println("__________________________________________________________________________________________________________\n\n");
                }
                else if(choice.equals("2")){
                    System.out.print("\n\nEnter Contact Number: ");
                    String contactNumber = input.next();
                    list[index][3] = validate_phone(contactNumber);//...Line 2198...
                    System.out.println("\n\n\n\t\t\t\tContact Number Updated Successfully");
                    System.out.println("__________________________________________________________________________________________________________\n\n");
                }

                //Modify the trainers' File (Store from 2d trainer Array to File)......
                try{
                    PrintWriter myFile = new PrintWriter("trainers.txt");
                    for(int i = 0;i<list.length;i++) {
                        for(int j = 0 ; j < list[0].length ; j++) {
                            myFile.print(list[i][j]+"#");
                        }
                        myFile.println();
                    }
                    myFile.close();
                }catch(FileNotFoundException e) {
                    System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program.");
                    System.exit(1);
                }catch(IndexOutOfBoundsException e) {
                    System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program.");
                    System.exit(1);
                }

                System.out.println("Would you like to modify anything else 'Y' / 'N' ?");
                String x1 = input.next();
                while(true){
                    if (x1.equalsIgnoreCase("Y") || x1.equalsIgnoreCase("N"))	{
                        break;		}
                    else	{
                        System.out.println("\n\t\t\t\tInvalid Choice.Choice must be Y/N");
                        x1 = input.next();	}
                }
                if (x1.equalsIgnoreCase("n"))
                    break;
                else{
                }
            }
        }
        System.out.println("__________________________________________________________________________________________________________");
    }
    //..............................................Method to Delete Trainers..............................................
    public static void delete_Trainers(String[][] Members, String[][] list, String[] AdminInfo, String[][]Machines) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nEnter the Registration Number to delete Trainer or 'Y' For Main Menu : ");
        String str = input.nextLine();
        str = validate_regNo(str,Members,list,AdminInfo,Machines);//...Line 2231...
        if (str.equalsIgnoreCase("y"))		mainmenu(Members, list, AdminInfo, Machines);//...Line 288...
        File myFile = new File("./trainers.txt");
        Scanner sc = new Scanner(myFile);
        boolean x = false;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if (s.startsWith(str)){
                x = true;
                System.out.print("\nTrainer found\nDo you want to Delete (Y/N): ");
                boolean loop = true;
                while(loop){
                    String choice = input.next();
                    if(choice.equalsIgnoreCase("y")){
                        break;
                    }
                    else if (choice.equalsIgnoreCase("n"))	{
                        loop = false;
                        return;		}
                    else
                        System.out.println("\n\t\t\t\tInvalid Choice.Choice should be (Y/N)");
                    System.out.print("\nEnter Choice Again: ");
                }
            }
        }
        if (x == false){
            System.out.println("Trainer not found\n");
            return;
        }
        sc.close();
        Scanner scan = new Scanner(myFile);
        String data = "";
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            if(!(line.startsWith(str)))
                data += line+"\n";
            else if (line.startsWith(str))
                data +=  "null#null#null#null#\n";
        }
        scan.close();
        myFile.delete();//Previous file deleted............................
        // create new file with the same name..............
        File myNewFile = new File("./trainers.txt");
        FileWriter writer = new FileWriter(myNewFile);
        writer.write(data);
        writer.close();
        System.out.println("\n\n\t\t\t\tTrainer removed successfully");
        File a2 = new File("trainers.txt");// Save New Data from New Trainers file to 2D Array
        Scanner ins = new Scanner(a2);
        for(int k = 0; k < list.length; k++){
            String dt = ins.nextLine();
            String[] Trn = dt.split("#");
            for(int s = 0; s < list[0].length; s++){
                list[k][s] = Trn[s];
            }
        }
        System.out.println("_________________________________________________________________________________________________________\n");
    }
    //..................................................Method For Details of Machine......................................
    public static void DetailsOfMachines(String[][] Members, String[][] trainer, String[] AdminInfo, String[][]Machines) throws IOException {
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tDetails Of A Machine ");
        int index = -1;
        String No;
        System.out.println("\n\nEnter Serial Number (0000 Format) ");
        System.out.print("(OR 'Y' for Main Menu: ");
        do{
            Scanner input = new Scanner(System.in);
            No = input.next();
            No = validate_regNo(No, Members, trainer, AdminInfo, Machines);//...Line 2231...
            for(int i = 0; i < Machines.length; i++){
                if(No.equals(Machines[i][0])){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                System.out.println("\n_________________________________________________________________________________________________________");
                System.out.println();
                System.out.println("\t\t\t\t* Details of "+Machines[index][1]+" *");
                System.out.println("_________________________________________________________________________________________________________\n");
                System.out.println("-> Serial Number: " + Machines[index][0]);
                System.out.println("-> Machine Name: " + Machines[index][1]);
                System.out.println("-> Weight: " + Machines[index][2] + " KG");
                System.out.println("-> Exercise: " + Machines[index][3]);
                System.out.println("_________________________________________________________________________________________________________\n");
            }
            else{
                System.out.println("\n\t\tMachine not found.Enter 'Y' for Main Menu or Serial number for details:  ");
            }
        }while(index == -1);
    }
    //.............................................Method to View All Machines.............................................
    public static void View_Machines(String[][] list) {
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tList Of Machines  ");
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\nSerial No."+"\t  "+ "\tNames\n");
        for (int i = 0; i < list.length; i++) {
            if (list[i][0].equals("null") == false) {
                System.out.println(list[i][0]+"\t\t| \t"+list[i][1]);
            }
        }
        System.out.println("_________________________________________________________________________________________________________");
    }
    //...................................................Method to Add New Machines........................................
    public static String[][] add_new_machines(String[][] list1) {
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tAdd New Machine\n\n");
        Scanner input = new Scanner(System.in);
        int index = -1;
        for(int i = 0; i < list1.length; i++) {
            if (list1[i][0].equals("null")) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("\n\t\t\t\tSorry, there is no space for New Machine\n");
        }
        if(index != -1)	{
            System.out.print("\t\tSerial Number is ==> ");
            String regNo = String.valueOf((int)(1000 + Math.random() * 1100));
            for (int i = 0; i < list1.length; i++) {
                while (list1[i][0].equals(regNo)) {
                    regNo = String.valueOf((int)(1000 + Math.random() * 1100));
                }
            }
            System.out.println(regNo);
            list1[index][0] = regNo;
            System.out.print("\nEnter the name of Machine: ");
            String name = input.nextLine();
            list1[index][1] = validate_name(name);//...Line 2171...
            int colunm = 2;
            String choiceforWeight = "3";
            InputforHeightAndWeight(list1,choiceforWeight,index,colunm);//...Line 2261...
            System.out.println("\nExercise : ");
            System.out.println("1- Chest");
            System.out.println("2- Back");
            System.out.println("3- Bicep");
            System.out.println("4- Triceps");
            System.out.println("5- ABS");
            System.out.println("6- Shoulders");
            System.out.println("7- Legs");
            System.out.println("8- Others");
            String choice2 = input.next();
            while(choice2.equals("1") == false && choice2.equals("2") == false && choice2.equals("3") == false && choice2.equals("4") == false
                    && choice2.equals("5") == false && choice2.equals("6") == false && choice2.equals("7") == false && choice2.equals("8") == false) {
                System.out.println("\n\t\t\t\tWrong choice! Select Valid Choice");
                System.out.print("\nChoose from 1-7: ");
                choice2 = input.next();
            }
            if(choice2.equals("1")) {
                list1[index][3] = "Chest";
            }
            if(choice2.equals("2")) {
                list1[index][3] = "Back";
            }
            if(choice2.equals("3")) {
                list1[index][3] = "Bicep";
            }
            if(choice2.equals("4")) {
                list1[index][3] = "Triceps";
            }
            if(choice2.equals("5")) {
                list1[index][3] = "ABS";
            }
            if(choice2.equals("6")) {
                list1[index][3] = "Shoulders";
            }
            if(choice2.equals("7")) {
                list1[index][3] = "Legs";
            }
            if(choice2.equals("8")) {
                list1[index][3] = "Others";
            }
            System.out.println("");
            System.out.println("");
            System.out.println("\t\t\t\t   Machine Added Successfully");
            System.out.println("_________________________________________________________________________________________________________\n");
        }
        return list1;
    }
    //...............................................Method to Delete Machines.............................................
    public static void delete_Machines(String list[][]) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nEnter the Serial No. to delete Machine: ");
        String str = input.nextLine();
        boolean y = true;
        while(y){
            if (str.equalsIgnoreCase("null")){
                System.out.print("\n\n\t\t\t\tYou Have entered Wrong Serial No.\nEnter Correct Serial NO. : ");
                str = input.nextLine();
            }else{y = false;}
        }
        File myFile = new File("Machines.txt");
        Scanner sc = new Scanner(myFile);
        boolean x = false;
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            if (s.startsWith(str)){
                x = true;
                System.out.print("\nMachine found\nDo you want to Delete (Y/N): ");
                boolean loop = true;
                while(loop){
                    String choice = input.next();
                    if (choice.equalsIgnoreCase("Y")){
                        break;}
                    else if (choice.equalsIgnoreCase("N")){
                        loop = false;
                        return;} //nothing return
                    else
                        System.out.println("\n\t\t\t\tIncorrect. Input must be Y or N \n");
                    System.out.print("Enter Choice again: ");
                }
            }
        }
        if(x == false){
            System.out.println("\nMachine not found\n");
            return;
        }sc.close();
        Scanner scan = new Scanner(myFile);
        String data = "";
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            if (line.startsWith(str))
                data +=  "null#null#null#null#null#null#null#null#null#null#null#null#\n";
            else
                data += line+"\n";
        }
        scan.close();//delete previous file.......................................
        myFile.delete();//create new file with the same name.........................
        File myNewFile = new File("./Machines.txt");
        FileWriter writer = new FileWriter(myNewFile); //write data from data(String) into Machine file.............
        writer.write(data);
        writer.close();
        System.out.println("\n\t\t\t\tMachine removed successfully");
        File a1 = new File("Machines.txt");
        Scanner inp = new Scanner(a1);//Storing data from file to Members 2d Array.................
        for(int i = 0; i < list.length; i++){
            String ab = inp.nextLine();
            String[] dta = ab.split("#");
            for(int j = 0; j < list[0].length; j++){
                list[i][j] = dta[j];
            }
        }System.out.println("_________________________________________________________________________________________________________\n");
    }
    //.......................................................Method to Book Machines.......................................
    public static void bookMachine(String[][] Members,String[][] trainer,String[] AdminInfo,String[][] Machines) throws IOException   {
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tMachine Reservation");
        System.out.println();
        Scanner input = new Scanner(System.in);
        int index = 0;
        int count = 0;
        int low;
        int high;
        int wh1 = 0;
        boolean n = true;
        System.out.print("Enter the Member's Registration Number (XXXX) or 'Y' for Main menu :\nOR Enter v to view Members list : ");
        do  {
            String regNo;
            int v = 0;
            while(true)	{
                regNo = input.next();
                if (regNo.equalsIgnoreCase("v")){
                    View_Members(Members);//...Line 589...
                    System.out.print("\nEnter the Member's Registration Number (XXXX) or 'Y' for Main Menu:\n OR v to View Members List:  ");
                }
                else if (regNo.equalsIgnoreCase("y"))
                    mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288...
                else if (!(regNo.length() == 4))	{
                    System.out.print("\n\t\t\t\tSeems incorrect... Reg. No has length upto 4 digits\nEnter the Member's Registration Number (XXXX) or 'Y' for Main menu :\nOR Enter v to view Members list : ");
                }
                else if (regNo.length() == 4)	{
                    wh1 = 0;
                    for(int i = 0; i < regNo.length(); i++)	{
                        if (!(Character.isDigit(regNo.charAt(i))))	{
                            System.out.print("\n\t\t\t\tSeems incorrect... Reg. should contain only digits\nEnter the Member's Registration Number (XXXX) or 'Y' for Main menu :\nOR Enter v to view Members list : ");
                            wh1++;
                            break;	}
                    }
                    if (wh1 == 0)	break;
                }
                else	break;	}
            for(int i = 0; i < Members.length; i++)   {
                if(regNo.equals(Members[i][0]))  {
                    index = i+1;
                    n = false;
                    break;   }
            }
            if (index == 0)
                System.out.print("\n\t\t\t\tMember not Found\n\nPlease Try Again or Enter Y for Main Menu\nOR Enter v to view Members list: ");
        }while(n);
        index--;
//Morning..........................................................................................
        if (Members[index][10].equals("Morning"))	{
            System.out.println("\n\n\n==> " + Members[index][1] + " " + Members[index][2]+" paid for Morning session at the Gym,Here is the list of morning reservations that are available ");
            while(true)	{
                int c = 0;
                for(int i = 0; i < Machines.length; i++)  {
                    for (int j = 4; j < 8; j++)	{
                        if((Members[index][0]).equals(Machines[i][j]))	c++;	}     }
                if (c < 4)	{
                    System.out.println();
                    System.out.println("\t\t\t  Following Machines are Available\n");
                    System.out.println("Serial No      Machines\t\t\t\t\tBooking\n");
                    for (int i = 0 ; i < Machines.length; i++)	{
                        count = 0;
                        if(!(Machines[i][0].equals("null")))	  {
                            for(int j = 4; j < 8; j++)	{
                                if(!(Machines[i][j].equals("null")))
                                    count++;	}
                            if (count == 4)
                                System.out.printf("-> %s  |  %-40s Fully Booked\n",Machines [i][0], Machines[i][1]);
                            else	{
                                count = 4 - count;
                                System.out.printf("-> %s  |  %-40s (%d Bookings are Available)\n", Machines[i][0], Machines[i][1], count);    }
                        }
                    }
                    System.out.println();
                    String machine_num;
                    int empty;
                    int res;
                    boolean loop = true;
                    String bufferEater = input.nextLine();   //Kill Space in buffer
                    while(loop){
                        empty = 0;
                        res = 0;
                        System.out.println("Enter Serial number of machine (you want) from list or 'Y' for Main Menu: ");
                        machine_num = input.next();
                        machine_num = validate_regNo(machine_num,Members,trainer,AdminInfo,Machines);//...Line 2231...
                        if (machine_num.equalsIgnoreCase("Y"))  {
                            mainmenu(Members, trainer, AdminInfo, Machines); break;	}//...Line 288...
                        for(int i = 0; i < Machines.length; i++) {
                            if(machine_num.equalsIgnoreCase(Machines[i][0])) {
                                for (int j = 4; j < 8; j++)   {
                                    if(Machines[i][j].equalsIgnoreCase(Members[index][0]))	{
                                        res = -1;
                                        break;   }
                                    if (res == 0)   {					}
                                    for (int k = 4; k < 8; k++) {
                                        if(Machines[i][k].equals("null"))  {
                                            empty = k;
                                            break;	}   }
                                }
                                if (res == -1)
                                    System.out.println("\n\t\t\tSorry You've already reserved this machine, Select a different machine\n");
                                else if (empty == 0)
                                    System.out.println("\n\t\t\tSadly, the machine is completely booked.\n");
                                else   {
                                    Machines[i][empty] = Members[index][0];
                                    System.out.println("\n\t\t  Machine Booked Successfully by " + Members[index][1] + " " + Members[index][2]);
                                    loop = false;	}
                            }
                        }
                    }
                }
                else	{System.out.println("\nWe apologise, but your Morning booking limit has reached. Maximum 4 Bookings are allowed");	break;	}
                //Modify the file Machines(Store from 2d Machines Array to File)
                try{  PrintWriter myFile = new PrintWriter("./Machines.txt");
                    for(int i = 0;i<Machines.length;i++) {
                        for(int j = 0 ; j < Machines[0].length ; j++) {
                            myFile.print(Machines[i][j]+"#");
                        }
                        myFile.println();
                    }
                    myFile.close();
                }catch(FileNotFoundException e) {
                    System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program\n");
                    System.exit(1);
                }catch(IndexOutOfBoundsException e) {
                    System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                    System.exit(1);
                }
                System.out.print("\nWant to book another one Y/N ? : ");
                String yn = input.next();
                while (true)	{
                    if (!(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")))	{
                        System.out.print("\n\t\t\t\tInvalid Choice...\nPlease enter Y/N : ");
                        yn = input.next();	}
                    else break;
                }
                if (yn.equalsIgnoreCase("n"))	break;
            }
        }
//Evening..........................................................................................
        else if (Members[index][10].equals("Evening"))	{
            System.out.println("\n\n\n==> " + Members[index][1] + " " + Members[index][2]+" paid for Evening session at the Gym,Here is the list of Evening reservations that are available ");
            while(true)	{
                int c = 0;
                for(int i = 0; i < Machines.length; i++)  {
                    for (int j = 8; j < 12; j++)	{
                        if((Members[index][0]).equals(Machines[i][j]))	c++;	}     }
                if (c < 4)	{
                    System.out.println();
                    System.out.println("\t\t\t  Following Machines are Available\n");
                    System.out.println("Serial No      Machines\t\t\t\t\tBooking\n");
                    for (int i = 0 ; i < Machines.length; i++)	{
                        count = 0;
                        if(!(Machines[i][0].equals("null")))	  {
                            for(int j = 8; j < 12; j++)	{
                                if(!(Machines[i][j].equals("null")))
                                    count++;	}
                            if (count == 4)
                                System.out.printf("-> %s  |  %-40s Fully Booked\n",Machines [i][0], Machines[i][1]);
                            else	{
                                count = 4 - count;
                                System.out.printf("-> %s  |  %-40s (%d Bookings are Available)\n", Machines[i][0], Machines[i][1], count);    }
                        }
                    }
                    System.out.println();
                    String machine_num;
                    int empty;
                    int res;
                    boolean loop = true;
                    String bufferEater = input.nextLine();//Kills Space in buffer...............
                    while(loop){
                        empty = 0;
                        res = 0;
                        System.out.println("Enter Serial number of machine (You Want) from list OR 'Y' to return to the Main Menu : ");
                        machine_num = input.nextLine();
                        machine_num = validate_regNo(machine_num,Members,trainer,AdminInfo,Machines);//...Line 2231...
                        if (machine_num.equalsIgnoreCase("Y"))  {
                            mainmenu(Members, trainer, AdminInfo, Machines); break;	}//...Line 288...
                        for(int i = 0; i < Machines.length; i++) {
                            if(machine_num.equalsIgnoreCase(Machines[i][0])) {
                                for (int j = 8; j < 12; j++)   {
                                    if(Machines[i][j].equalsIgnoreCase(Members[index][0]))	{
                                        res = -1;
                                        break;   }
                                    if (res == 0)   {					}
                                    for (int k = 8; k < 12; k++) {
                                        if(Machines[i][k].equals("null"))  {
                                            empty = k;
                                            break;	}   }
                                }
                                if (res == -1)
                                    System.out.println("\n\t\t\tSorry You've already reserved this machine, Select a different machine\n");
                                else if (empty == 0)
                                    System.out.println("\n\t\t\tSadly, the machine is completely booked.\n");
                                else   {
                                    Machines[i][empty] = Members[index][0];
                                    System.out.println("\n\t\t  Machine Booked Successfully by " + Members[index][1] + " " + Members[index][2]);
                                    loop = false;	}
                            }
                        }
                    }
                }
                else	{
                    System.out.println("\nWe apologise,but your Evening booking limit has reached. Maximum 4 Bookings are allowed ");	break;	}

                //Modify the file Machines(Store from 2d Machines Array to File)
                try{  PrintWriter myFile = new PrintWriter("./Machines.txt");
                    for(int i = 0;i<Machines.length;i++) {
                        for(int j = 0 ; j < Machines[0].length ; j++) {
                            myFile.print(Machines[i][j]+"#");
                        }
                        myFile.println();
                    }
                    myFile.close();
                }catch(FileNotFoundException e) {
                    System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program\n");
                    System.exit(1);
                }catch(IndexOutOfBoundsException e) {
                    System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                    System.exit(1);
                }

                System.out.print("\nWant to book another one 'Y/N' ? : ");
                String yn = input.next();
                while (true)	{
                    if (!(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")))	{
                        System.out.print("\n\t\t\t\tInvalid Choice...\nPlease enter Y/N : ");
                        yn = input.next();	}

                    else break;
                }
                if (yn.equalsIgnoreCase("n"))	break;
            }
        }
        System.out.println("_________________________________________________________________________________________________________");
    }


    //..............................................Method for Cancelling Booking..........................................
    public static void cancelBooking(String[][] Members,String[][] trainer,String[] AdminInfo,String[][] Machines) throws IOException  {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tMachine Booking Cancellation");
        System.out.println();
        int index = 0;
        int wh1 = 0;
        boolean n = true;
        System.out.print("\nEnter the Member's Registration Number (XXXX) or 'Y' for Main Menu \nOR Enter 'V' to View Members list : ");
        do  {
            String regNo;
            while(true)	{
                regNo = input.next();
                if (regNo.equalsIgnoreCase("v"))	{
                    View_Members(Members);//...Line 589...
                    System.out.print("\nEnter the Member's Registration Number (XXXX) or 'Y' for Main Menu\nOR Enter 'V' to view Members list : ");
                }
                else if (regNo.equalsIgnoreCase("y"))
                    mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288...
                else if (!(regNo.length() == 4))	{
                    System.out.print("\n\t\t\t\tSeems incorrect... Reg. No has length upto 4 digits\nEnter the Member's Registration Number (XXXX) or 'Y' for Main menu :\nOR Enter v to view Members list : ");
                }
                else if (regNo.length() == 4)	{
                    wh1 = 0;
                    for(int i = 0; i < regNo.length(); i++)	{
                        if (!(Character.isDigit(regNo.charAt(i))))	{
                            System.out.print("\n\t\t\t\tSeems incorrect... Reg. should contain only digits\nEnter the Member's Registration Number (XXXX) or 'Y' for Main menu :\nOR Enter v to view Members list : ");
                            wh1++;
                            break;	}
                    }
                    if (wh1 == 0)	break;
                }
                else	break;	}

            for(int i = 0; i < Members.length; i++)   {
                if(regNo.equals(Members[i][0]))  {
                    index = i+1;
                    n = false;
                    break;   }
            }
            if (index == 0)
                System.out.print("\n\t\t\t\tMember not Found\n\nPlease Try Again or Enter Y for Main Menu\nOR Enter v to view Members list: ");
        }while(n);
        index--;
        while(true)	{
            int mCount = 0;
            int eCount = 0;
            //..............................Morning Bookings.....................................
            if (Members[index][10].equals("Morning"))	{
                System.out.println();
                System.out.println("\n\t\t\t\t\t*******************");
                System.out.println("\t\t\t\t\t**Morning Bookings**");
                System.out.println("\t\t\t\t\t*******************\n");
                System.out.println(" Serial No   \t\tMachines Name\n");
                System.out.println("_________________________________________________________________________________________________________");
                for (int i = 0;i < Machines.length; i++)
                    for (int j = 4; j < 8; j++)	{
                        if((Members[index][0]).equalsIgnoreCase(Machines[i][j]))	{
                            System.out.println("> "+Machines[i][0] + "        |\t\t" + Machines[i][1]);	 mCount++;	}	}
                if (mCount == 0)	{
                    System.out.println("> No Bookings........");	break;	}

                System.out.println("_________________________________________________________________________________________________________");
            }
            //.............................Evening Bookings......................................
            if (Members[index][10].equals("Evening"))	{
                System.out.println();
                System.out.println("\n\t\t\t\t\t*******************");
                System.out.println("\t\t\t\t\t**Evening Booking**");
                System.out.println("\t\t\t\t\t*******************\n");
                System.out.println(" Serial No   \t\tMachines Name\n");
                System.out.println("_________________________________________________________________________________________________________");
                for (int i = 0;i < Machines.length; i++)
                    for (int j = 8; j < 12; j++)	{
                        if((Members[index][0]).equalsIgnoreCase(Machines[i][j]))	{
                            System.out.println("> "+Machines[i][0] + "        |\t\t" + Machines[i][1]);	eCount++;	}	}
                if (eCount == 0)	{
                    System.out.println("> No Bookings........");	break;	}

                System.out.println("_________________________________________________________________________________________________________\n");
            }

            if (mCount != 0 || eCount != 0)	{

                if (Members[index][10].equals("Morning"))	{
                    System.out.print("To cancel a reservation, enter the Machine's Serial Number or 'Y' to return : ");
                    boolean loop = true;
                    int col = 0;
                    int row = 0;
                    while(loop)	{
                        String No = input.next();
                        No = validate_regNo(No, Members, trainer, AdminInfo, Machines);//...Line 2231...

                        for (int i = 0;i < Machines.length; i++)
                            if (No.equals(Machines[i][0]))	{
                                row = i;	break;   }

                        for (int j = 4; j < 8; j++)	{
                            if((Members[index][0]).equalsIgnoreCase(Machines[row][j]))	{
                                loop = false;   col = j; break;	}	}
                        if (loop == true)
                            System.out.print("Please enter the Serial number from above Morning list  or 'Y' for Main menu: ");
                    }

                    System.out.print("\nWant to cancel your reservation Y/N ? : ");
                    String cho = input.next();
                    while(true)  {
                        if (!(cho.equals("y") || cho.equals("n")))   {
                            System.out.print("\n\t\t\t\tInvalid Choice...... \nPlease Choose from Y/N: ");
                            cho = input.next();
                        }
                        else break;
                    }
                    if (cho.equalsIgnoreCase("n"))	{
                        mainmenu(Members, trainer, AdminInfo, Machines);   }//...Line 288...
                    else if (cho.equalsIgnoreCase("y"))	{
                        Machines[row][col] = "null";
                        System.out.println();
                        System.out.println("\n\n\t\t\t Successful cancellation of the reservation of " + Members[index][1] + " " + Members[index][2]);
                        System.out.println("_________________________________________________________________________________________________________\n");	}
                }
                else if (Members[index][10].equals("Evening"))	{
                    System.out.print("To cancel a reservation, Enter the Machine's Serial Number or 'Y' to return : ");
                    boolean loop = true;
                    int col = 0;
                    int row = 0;
                    while(loop)	{
                        String No = input.next();
                        No = validate_regNo(No, Members, trainer, AdminInfo, Machines);//...Line 2231...

                        for (int i = 0;i < Machines.length; i++)
                            if (No.equals(Machines[i][0]))	{
                                row = i;	break;   }
                        for (int j = 8; j < 12; j++)	{
                            if((Members[index][0]).equalsIgnoreCase(Machines[row][j]))	{
                                loop = false;  col = j; break;	}	}
                        if (loop == true)
                            System.out.print("Please enter Serial Number from above Evening list OR 'Y' for Main menu: ");
                    }

                    System.out.print("\nWant to cancel your reservation Y/N ? : ");
                    String cho = input.next();
                    while(true)  {
                        if (!(cho.equals("y") || cho.equals("n")))   {
                            System.out.print("\n\t\t\t\tInvalid Choice..... \nPlease Choice from Y/N : ");
                            cho = input.next();
                        }
                        else break;
                    }
                    if (cho.equalsIgnoreCase("n"))	{
                        mainmenu(Members, trainer, AdminInfo, Machines);   }//...Line 288...
                    else if (cho.equalsIgnoreCase("y"))	{
                        Machines[row][col] = "null";
                        System.out.println();
                        System.out.println("\n\n\t\t\tSuccessful cancellation of the reservation of " + Members[index][1] + " " + Members[index][2]);
                        System.out.println("_________________________________________________________________________________________________________\n");	}
                }

            }

            //Modify the file Machines(Store from 2d Machines Array to File)
            try{  PrintWriter myFile1 = new PrintWriter("./Machines.txt");
                for(int i = 0;i<Machines.length;i++) {
                    for(int j = 0 ; j < Machines[0].length ; j++) {
                        myFile1.print(Machines[i][j]+"#");
                    }
                    myFile1.println();
                }
                myFile1.close();
            }catch(FileNotFoundException e) {
                System.out.println("\n\t\t\t\tFile not found.... Sorry we are Closing Program\n");
                System.exit(1);
            }catch(IndexOutOfBoundsException e) {
                System.out.println("\n\t\t\t\tIndex out of bound exception...Sorry we are Closing Program\n");
                System.exit(1);
            }

            System.out.print("\nWant to cancel another one Y/N ? : ");
            String yn = input.next();
            while (true)	{
                if (!(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")))	{
                    System.out.print("\n\t\t\t\tInvalid Choice.....\nPlease enter Y/N : ");
                    yn = input.next();	}
                else break;
            }
            if (yn.equalsIgnoreCase("n"))	break;

        }

    }
    //...................................................Method for Booking Details....................................
    public static void bookingDetail(String[][] Members,String[][] trainer,String[] AdminInfo,String[][] Machines) throws IOException  {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t\tMachine Reservation Details\n");
        System.out.println();
        int index = -1;
        boolean n = true;
        System.out.print("Enter the Member's Registration Number (XXXX) or 'Y' for Mainmenu : ");
        do  {
            String regNo = input.next();
            regNo = validate_regNo(regNo, Members, trainer, AdminInfo, Machines);//...Line 2231...
            for(int i = 0; i < Members.length; i++)   {
                if(regNo.equals(Members[i][0]))  {
                    index = i;
                    System.out.println("\nMember : " + Members[i][1] + " " + Members[i][2]);
                    n = false;
                    break;   }
            }
            if (index == -1)
                System.out.print("\n\t\t\t\tMember not Found\nPlease Try Again or Enter Y for Main Menu: ");
        }while(n);

        int mCount = 0;
        int eCount = 0;
        System.out.println();
        System.out.println("\t\t\t\t\t*******************");
        System.out.println("\t\t\t\t\t**Morning Booking**");
        System.out.println("\t\t\t\t\t*******************\n");

        System.out.println("\n Serial No   \t\tMachine Name");
        System.out.println("_________________________________________________________________________________________________________");
        for (int i = 0;i < Machines.length; i++)
            for (int j = 4; j < 8; j++)	{
                if((Members[index][0]).equalsIgnoreCase(Machines[i][j]))	{
                    System.out.println("> "+Machines[i][0] + "        |\t\t" + Machines[i][1]);	mCount++;	}	}
        if (mCount == 0)
            System.out.println("> No Bookings.........");

        System.out.println("_________________________________________________________________________________________________________");
        System.out.println();
        System.out.println("\t\t\t\t\t*******************");
        System.out.println("\t\t\t\t\t**Evening Booking**");
        System.out.println("\t\t\t\t\t*******************\n");

        System.out.println("\n Serial No   \t\tMachine Name");

        System.out.println("_________________________________________________________________________________________________________");
        for (int i = 0;i < Machines.length; i++)
            for (int j = 8; j < 12; j++)	{
                if((Members[index][0]).equalsIgnoreCase(Machines[i][j]))	{
                    System.out.println("> "+Machines[i][0] + "        |\t\t" + Machines[i][1]);	eCount++;	}	}
        if (eCount == 0)
            System.out.println("> No Bookings.........");

        System.out.println("_________________________________________________________________________________________________________");
    }
    //..........................................Method for Morning Booking Info........................................
    public static void morningBookingInfo(String[][] Members, String [][]Machines)	{

        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t    Machine Reservation Details");
        System.out.println();

        int mCount = 0;
        int rowM = 0;
        System.out.println();
        System.out.println("\t\t\t\t\t*******************");
        System.out.println("\t\t\t\t\t**Morning Booking**");
        System.out.println("\t\t\t\t\t*******************\n");

        System.out.println("_________________________________________________________________________________________________________\n");
        System.out.println(" Machines Name         \t\t\t\tReserved By\t\tReg No's");
        System.out.println("_________________________________________________________________________________________________________");
        for (int i = 0;i < Machines.length; i++)
            for (int j = 4; j < 8; j++)	{
                if(!(Machines[i][j].equals("null")))	{
                    for (int k = 0; k < Members.length; k++){
                        if (Machines[i][j].equals(Members[k][0]))	{
                            rowM = k; break;	}
                    }
                    System.out.printf("-> %-20s \t |\t\t %s %-19s%s\n",Machines [i][1], Members[rowM][1], Members[rowM][2], Members[rowM][0]);	mCount++;	}	}
        if (mCount == 0)
            System.out.println("> No Bookings.........");

        System.out.println("_________________________________________________________________________________________________________");

    }
    //..............................................Method for Evening BookingInfo.........................................
    public static void eveningBookingInfo(String[][] Members, String [][]Machines)	{

        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t    Machine Reservation Details");
        System.out.println();

        int mCount = 0;
        int rowM = 0;
        System.out.println();
        System.out.println("\t\t\t\t\t*******************");
        System.out.println("\t\t\t\t\t**Evening Booking**");
        System.out.println("\t\t\t\t\t*******************\n");

        System.out.println("_________________________________________________________________________________________________________\n");
        System.out.println(" Machines Name         \t\t\t\tReserved By\t\tReg No's");
        System.out.println("_________________________________________________________________________________________________________");
        for (int i = 0;i < Machines.length; i++)
            for (int j = 8; j < 12; j++)	{
                if(!(Machines[i][j].equals("null")))	{
                    for (int k = 0; k < Members.length; k++){
                        if (Machines[i][j].equals(Members[k][0]))	{
                            rowM = k; break;	}
                    }
                    System.out.printf("-> %-20s \t |\t\t %s %-19s%s\n",Machines [i][1], Members[rowM][1], Members[rowM][2], Members[rowM][0]);	mCount++;	}	}
        if (mCount == 0)
            System.out.println("> No Bookings.........");

        System.out.println("_________________________________________________________________________________________________________");

    }
    //..............................................Method to Reset Booking............................................
    public static String[][] resetBooking(String[][] Members, String[][] trainer, String[] AdminInfo, String[][]Machines) throws IOException  {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t**********************");
        System.out.println("\t\t\t\t\t**Reset Reservations**");
        System.out.println("\t\t\t\t\t**********************");
        System.out.println("_________________________________________________________________________________________________________\n");
        System.out.println("Which Reservations would you like to Reset?");
        System.out.println("1. Morning");
        System.out.println("2. Evening");
        System.out.println("3. Both");
        System.out.println("0. Main Menu\n");
        System.out.print("Enter Your Choice: ");
        String cho = input.next();
        while(true)   {
            if (!(cho.equals("1") || cho.equals("2") ||cho.equals("3") ||cho.equals("0")))   {
                System.out.print("\n\t\t\t\tInvalid Choice.... \nPlease Try Again: ");	cho = input.next();  }
            else	break;
        }
        if (cho.equals("0"))	{
            mainmenu(Members, trainer, AdminInfo, Machines);	}//...Line 288...
        if(cho.equals("1")){
            System.out.println("\nDo you want to remove all of The Morning Reservation details Y/N ?");
        }
        if(cho.equals("2")){
            System.out.println("\nDo you want to remove all of The Evening Reservation details Y/N ?");
        }
        if (cho.equals("3")){
            System.out.println("\nDo you want to remove all of the Reservation details Y/N ?");
        }
        System.out.print("Enter Your Choice: ");
        String yn = input.next();
        while(true)   {
            if (!(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")))   {
                System.out.print("\n\t\t\t\tInvalid Choice.... \nPlease Try Again: ");	yn = input.next();  }
            else	break;
        }
        if (yn.equalsIgnoreCase("n"))	{
            mainmenu(Members, trainer, AdminInfo, Machines);}//...Line 288...

        if (cho.equals("1") || cho.equals("3"))	{
            for (int i = 0; i < Machines.length; i++)
                for(int j = 4; j < 8; j++)
                    Machines[i][j] = "null";
        }
        if (cho.equals("2") || cho.equals("3"))	{
            for (int i = 0; i < Machines.length; i++)
                for(int j = 8; j < 12; j++)
                    Machines[i][j] = "null";
        }
        System.out.println("\n_________________________________________________________________________________________________________");
        System.out.println("\t\t\t\t    Reservations have been reset");
        System.out.println("---------------------------------------------------------------------------------------------------------\n\n");
        return Machines;
    }
    //..........................................Method to Validate Name....................................................
    public static String validate_name(String name){
        Scanner input = new Scanner(System.in);
        int count;
        //Validating only alphabets in input.............................................
        while(true)	{
            if(name.length() > 30)	{
                System.out.println("\n\t\t\t\t\tSeems incorrect,Please try again: ");
                name = input.nextLine();}
            else	break;	}
        while(true)	{
            count = 0;
            for(int i =0; i < name.length(); i++)	{
                if (!(Character.isLetter(name.charAt(i)) || name.charAt(i) == '.'  || name.charAt(i) == ' ')){
                    System.out.println("\n\t\t\t\tIt appears that you entered the wrong name,Please try again ");
                    count++;
                    break;
                }
            }
            if (count != 0)		{
                name = input.nextLine();
            }
            else
                break;
        }
        return name;
    }
    //........................................Method to Validate Phone Number..............................................
    public static String validate_phone(String contactNumber){
        Scanner input = new Scanner(System.in);
        int count;
        //Validation of Correct format of phone Number.........
        while(true)	{
            if (!((contactNumber.length() == 12 && contactNumber.charAt(4) == '-' && contactNumber.charAt(0) == '0'
                    && contactNumber.charAt(1) == '3')&&(contactNumber.charAt(2) == '0' || contactNumber.charAt(2) == '2' ||
                    contactNumber.charAt(2) == '1' || contactNumber.charAt(2) == '4' || contactNumber.charAt(2) == '3')))	{
                System.out.println("\n\t\tIt appears that you entered the wrong Phone Number.Correct format is (03XX-XXXXXXX).Try again \n");
                contactNumber = input.next();
            }
            else	{
                count = 0;
                for(int i =0; i < contactNumber.length(); i++)	{
                    if (!(Character.isDigit(contactNumber.charAt(i))))	{
                        if (i == 4)	{
                            continue;
                        }
                        System.out.println("\n\t\tIt appears that you entered the wrong Phone Number.Correct format is (03XX-XXXXXXX).Try again \n");
                        count++;
                        break;
                    }
                }
                if (count != 0)		{
                    contactNumber = input.next();
                }
                else
                    break;
            }
        }
        return contactNumber;
    }
    //.....................................Method to Validate Registration Number..........................................
    public static String validate_regNo(String regNo, String[][]Members, String[][] trainer, String[] AdminInfo, String[][] Machines) throws IOException	{
        Scanner input = new Scanner(System.in);
        int count;
        while(true)	{//...Validation for Maintaining only 4 Numbers in Input...
            if (regNo.equalsIgnoreCase("y"))	{
                mainmenu(Members, trainer, AdminInfo, Machines);//...Line 288...
            }
            else if (!(regNo.length() == 4))	{
                System.out.println("\n\t\tIt appears that you entered the wrong format.Please enter only 4 digits RegNo or Y for Main Menu ");
                regNo = input.next();
            }
            else	{
                count = 0;
                for(int i =0; i < regNo.length(); i++)	{
                    if (!(Character.isDigit(regNo.charAt(i))))	{
                        System.out.println("\n\t\tIt appears that you entered the wrong format.Please enter only digits or Y for Main Menu ");
                        count++;
                        break;
                    }
                }
                if (count != 0)		{
                    regNo = input.next();
                }
                else
                    break;
            }
        }
        return regNo;
    }
    //....................................Method to Input Height or Weight.................................................
    public static void InputforHeightAndWeight(String list[][], String choice, int index, int i){
        Scanner input = new Scanner(System.in);
        boolean takeInput = true;
        double weightdoub;
        double heightdoub;
        String str = (choice.equals("3"))?"weight":"height";
        do{
            try{
                if(choice.equals("3")) {
                    System.out.print("\nEnter Weight in Kg: ");
                    while(true)	{
                        weightdoub = input.nextDouble();
                        if (weightdoub > 0 && weightdoub < 300)
                            break;
                        else
                            System.out.println("\n\t\t\t\tWeight seems incorrect. Please try once more.");	}
                    String weightstr = String.valueOf(weightdoub);
                    list[index][i] = weightstr;
                    takeInput = false;
                }
                else {
                    System.out.print("\nEnter Height (-feet.-inch): ");
                    while(true)	{
                        heightdoub = input.nextDouble();
                        if (heightdoub > 0 && heightdoub < 10)
                            break;
                        else
                            System.out.println("\n\t\t\t\tHeight seems incorrect. Please try once more.");	}
                    String heightstr = String.valueOf(heightdoub);
                    list[index][i] = heightstr;
                    takeInput = false;
                }
            }catch (Exception ex) {
                System.out.println("\n\t\t\t\tTry again. (" + "Incorrect input: "+str+" must be in a number)");
                input.nextLine();
            }
        }while(takeInput);
    }
}