import java.util.*;

//String alphabet = "абвгдеёжзийклмнопрстуфхцшщчъыьэюяabcdefghijklmnopqrstuvwxyz";

class Task {
    public static void main (String [] args) {      
       
        People p = new People();
        p = userInput(p);
        p.printAllInfo();
       
    }   
    // Метод для проверки текста на наличие цифр и символов
    public static Boolean checkText(String text) {
         int strlen = 0;
         String numsAndSymbols = "0123456789.,\";:!`~?\'[]{}()<>#$%^&*/+@.=|\\";
         String ltext = text.toLowerCase();
         for(int i = 0; i < ltext.length(); i++) {  
            for(int j = 0; j < numsAndSymbols.length(); j++) {
                if (ltext.charAt(i) == numsAndSymbols.charAt(j)) {
                    strlen +=1; 
                }
            }
        }
        if (strlen == 0) {
            return true;
        } else {
            return false;
        }        
    }
 
    // Метод для проработки ошибок ввода фамилии
    public static String checkSurname() {
        Scanner scan = new Scanner(System.in); 
        String userInput = "";
        String surEnd = "";
        String accept = "";
        
        Boolean approve = true;
        while (approve) {
            System.out.println("Повторно введите фамилию: ");
            userInput = scan.nextLine();
            surEnd +=  userInput.charAt(userInput.length() - 1) + userInput.charAt(userInput.length() - 2);
            if (surEnd == "ов" || surEnd == "ва" || surEnd == "на" || surEnd == "ин" || surEnd == "ев") {
                if (checkText(userInput)) {
                    scan.close();
                    return userInput;
                } else {
                    System.out.println("В тексте имеются посторонние символы\n");
                }
            } else {
                System.out.println("Введенный текст " + userInput + " не является фамилией в результате анализа имеющихся критерий!\n");                
                surEnd = "";
                while(true) {
                    System.out.println("Принять введенную фамилию: \"" + userInput + "\"?  (y / n) \n");
                    accept = scan.nextLine();
                    if (accept == "y") {
                        scan.close();  
                        return userInput;
                    } else if (accept == "n") {
                        System.out.println("В тексте имеются посторонние символы\n");
                        break;
                    } else {
                        System.out.println("Некорректный ответ!\n");
                    }
                }
            }
        }
        scan.close();
        return userInput;
    }

    // Метод для проработки ошибок ввода отчества
    public static String checkPatronymic() {
        Scanner scan = new Scanner(System.in); 
        String userInput = "";
        String patroEnd = "";
        String accept = "";
        Boolean approve = true;
        while (approve) {
            System.out.println("Повторно введите отчество: ");
            userInput = scan.nextLine();
            patroEnd += userInput.charAt(userInput.length() - 1) + userInput.charAt(userInput.length() - 2) + userInput.charAt(userInput.length() - 3); 
            if (patroEnd == "вич" || patroEnd == "вна") {
                if (checkText(userInput)) {
                    scan.close();  
                    return userInput;
                } else {
                    System.out.println("В тексте имеются посторонние символы\n");
                }
            } else {
                patroEnd = "";
                System.out.println("Введенный текст " + userInput + " не является отчеством в результате анализа имеющихся критерий!\n");                
                while(true) {
                    System.out.println("Принять введенное отчество: \"" + userInput + "\"?  (y / n) \n");
                    accept = scan.nextLine();
                    if (accept == "y") {
                        scan.close();  
                        return userInput;
                    } else if (accept == "n") {
                        System.out.println("В тексте имеются посторонние символы\n");
                        break;
                    } else {
                        System.out.println("Некорректный ответ!\n");
                    }
                }
            }
        }
        scan.close();  
        return userInput;
    }
    
    // Метод для обработки ошибок ввода даты рождения
    public static String checkBirth(String date) {
        Scanner scan = new Scanner(System.in);
        ArrayList <Character> arrNums = new ArrayList<>() {{add('0'); add('1'); add('2'); add('3'); add('4'); add('5'); add('6'); add('7'); add('8'); add('9');}};
        Map <Integer, Integer> arrDaysMounth = new HashMap<>() {{put(1, 31); put(2, 28); put(3, 31); 
                                               put(4, 30); put(5, 31); put(06, 30);                                               
                                               put(7, 31); put(8, 31); put(9, 30);
                                               put(10, 30); put(11, 30); put(12, 31);}};
        int volume = 0;        
        String userInput = date;
        String mounth, days, year;
        int d, y, m;
        Boolean accept = true;

        while(accept) {
            if (userInput.length() == 10 && userInput.charAt(2) == '.' && userInput.charAt(5) == '.') {            
                for(int i = 0; i < userInput.length(); i++) {
                    for(char k : arrNums) {
                        if (userInput.charAt(i) == k) {
                            volume +=1;
                            break;
                        }
                    }                    
                }                
                if (volume == 8) {
                    d = 0;
                    days = "";
                    days += userInput.charAt(0);
                    days += userInput.charAt(1);
                    d = Integer.parseInt(days);

                    m = 0;
                    mounth = "";
                    mounth += userInput.charAt(3);
                    mounth += userInput.charAt(4);
                    m = Integer.parseInt(mounth);
                    
                    y = 0;
                    year = "";
                    year += userInput.charAt(6);
                    year += userInput.charAt(7);
                    year += userInput.charAt(8);
                    year += userInput.charAt(9);
                    y = Integer.parseInt(year);

                    if (y % 4 == 0) {                        
                        for(Map.Entry<Integer, Integer> item : arrDaysMounth.entrySet()){
                            if (m == 2 ) {
                                if (d > 0 && d <= 29) {
                                    scan.close();
                                    return userInput;
                                } 
                            } else if (m == item.getKey()) {                               
                                if (d > 0 && d <= item.getValue()) {                                    
                                    scan.close();                                    
                                    return userInput;
                                }
                            }
                        }
                    } else {
                        for(Map.Entry<Integer, Integer> item : arrDaysMounth.entrySet()){
                            if (m == item.getKey()) {
                                if (d > 0 && d <= item.getValue()) {
                                    scan.close();
                                    return userInput;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("============================================================================");
            System.out.println("Введеная дата рождения: " + userInput + " не соответствует заданным параметрам!");                
            System.out.println("Формат ввода даты рождения: дд.мм.гггг");
            System.out.println("============================================================================\n");
            System.out.println("Введите дату рождения:");
            userInput = scan.nextLine();
        }
        scan.close();
        return userInput;
    }

    // Метод для обработки ошибок ввода номера телефона
    public static String checkPhone() {
        Scanner scan = new Scanner(System.in); 
        List<Character> arrnums = new ArrayList <>() {{add('0'); add('1'); add('2'); add('3'); add('4'); add('5'); add('6'); add('7'); add('8'); add('9');}}; 
        String userInput = "";
        int volume;
        Boolean accept = true;

        while(accept) {
            volume = 0;
            System.out.println("Номер телефона состоит из 11 цифр и начинается с 8 или +7! \n");
            System.out.println("Повторно введите номер телефона: \n");
            userInput = scan.nextLine();
            if ((userInput.length() == 10 && userInput.charAt(0) == '8') ||                                     
            (userInput.length() == 10 && Character.toString(userInput.charAt(0) + userInput.charAt(1)) == "+7")) {
                for(int i =0; i < userInput.length(); i++) {
                    for (char k : arrnums) {
                        if (userInput.charAt(i) == k) {
                            volume += 1;
                            break;
                        }
                    }
                }
                if (volume == userInput.length()) {
                    scan.close();
                    return userInput;
                } else {
                    System.out.println("В введенном номере телефона имеются посторонние символы\n");
                    System.out.println("Повторите попытку!\n\n");
                    volume = 0;
                }
            } else {
                System.out.println("Введенный номер телефона начинается не с 8 или +7 или его длина не 11 чисел\n");
                System.out.println("Повторите попытку!\n\n");
                volume = 0;
            }
        }
        scan.close();
        return userInput;
    }


    // Метод для обработки ошибок ввода имени


    // Основной запускаемый метод с ответвлениями
    public static People userInput(People p) {
        Scanner scan = new Scanner(System.in); 
        List<String> arrList = new ArrayList<>();

        List<Character> arrnums = new ArrayList <>() {{add('0'); add('1'); add('2'); add('3'); add('4'); add('5'); add('6'); add('7'); add('8'); add('9');}};
        List<String> arrEements = new ArrayList <>(){{add("Surname"); add("Name"); add("Patronymic"); add("Birth"); add("Phone"); add("Floor");}};
        
        String inputText, text = "";
        Boolean access = true;
        int index, volume;

        while (access) {            
            index = -1;
            volume = 0;
            System.out.println("Введите в произвольном порядке ФИО, дату рождения, номер телефона и пол через пробелы в формате:");
            System.out.println("ФИО - Фамилия Имя Отчетство");
            System.out.println("Дата рождения - дд.мм.гггг");
            System.out.println("Номер телефона - 89991234567");
            System.out.println("Пол - f или m\n");
            

            inputText = scan.nextLine(); 
            if (inputText == "") { 
                System.out.println("/============================================\\"); 
                System.out.println("|        Ошибка! Ничего не введено!          |");                
                System.out.println("|           Повторите попытку!               |");
                System.out.println("\\============================================/");
            } else {
                // Извлечение из текста информации и перенос ее в массив arrList                 
                for (int i = 0; i < inputText.length(); i++) {
                    if (inputText.charAt(i) != ' ') {
                        text +=inputText.charAt(i);
                    } else {
                        arrList.add(text);
                        text = "";
                    }
                    if (i == inputText.length() -1) {
                        arrList.add(text);
                        text = "";
                    }
                } 

                if (arrList.size() != 6) {

                    System.out.println("/============================================\\"); 
                    System.out.println("|               Ошибка ввода!                |");                
                    System.out.println("|   Введены не все запрашиваемые элементы!   |");
                    System.out.println("\\============================================/"); 
                
                } else {                    
                    // Рассмотрение каждого элемента массива 
                    
                    String sur, patro;
                    for(String temp : arrList) {
                        index += 1;                        
                        sur = "";
                        patro = "";
                        sur += temp.charAt(temp.length() - 1);
                        sur += temp.charAt(temp.length() - 2);

                        patro += temp.charAt(temp.length() - 1);
                        patro += temp.charAt(temp.length() - 2);
                        patro += temp.charAt(temp.length() - 3);                        
                        //Проверка элемента на совпадение с критериями определения фамилии
                        if (sur == "ов" || sur == "ва" || sur == "на" || sur == "ин" || sur == "ев") {                            
                            if (checkText(temp)) {
                                p.setSurname(temp);
                                arrEements.remove(index);
                                //arrList.remove(index);
                            } else {
                                System.out.println("В тексте имеются посторонние символы\n");
                                p.setSurname(checkSurname());
                                arrEements.remove(index);
                                //arrList.remove(index);
                            }
                        // Проверка элемента на совпадение с критериями определения отчества
                        } else if (patro == "вич" || patro == "вна") {                            
                            if (checkText(temp)) {
                                p.setPatronymic(temp);
                                //arrList.remove(index);
                                arrEements.remove(index);
                            } else {
                                System.out.println("В тексте имеются посторонние символы\n");
                                p.setPatronymic(checkPatronymic());
                                //arrList.remove(index);
                                arrEements.remove(index);
                            }
                        // Проверка элемента на совпадение с критериями определения даты рождения
                        } else if ((temp.length() == 10 && temp.charAt(2) == '.' && temp.charAt(5) == '.') || (temp.length() == 10 && temp.charAt(2) == '.' && temp.charAt(7) == '.') || (temp.length() == 10 && temp.charAt(4) == '.' && temp.charAt(7) == '.') ) {
                                p.setBirth(checkBirth(temp));
                                //arrList.remove(index);
                                arrEements.remove(index);
                        
                        // Проверка элемента на совпадение с критериями определения номера телефона       
                        } else if ((temp.length() == 10 && temp.charAt(0) == '8') ||                                     
                            (temp.length() == 10 && Character.toString(temp.charAt(0) + temp.charAt(1)) == "+7")) {
                            for(int i = 0; i < temp.length(); i++) {
                                for(char k : arrnums) {
                                    if (temp.charAt(i) == k) {
                                        volume +=1;
                                        break;
                                    }
                                }
                            }

                            if (volume == temp.length()) {
                                p.setPhone(temp);
                                //arrList.remove(index);
                                arrEements.remove(index);
                            } else {
                                System.out.println("В введенном номере телефона: " + temp + ". имеются посторонние символы\n");
                                p.setPhone(checkPhone());
                                //arrList.remove(index);
                                arrEements.remove(index);
                                volume = 0;
                            }
                        }                        
                    }                    
                }
            }
        }

        scan.close();
        return p;
    }
}
