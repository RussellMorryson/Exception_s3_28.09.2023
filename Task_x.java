import java.util.*;
import java.io.*;


public class Task_x {
    public static void main (String [] args) {
        People p = new People();
        p = createPeople();

        try(FileWriter fw = new FileWriter("note.txt", true)) {
            fw.write(p.allInfo() + "\n");
            fw.flush();
        } catch(IOException e){ System.out.println(e.getMessage()); }
    }

// Пользовательский ввод и начало анализа введенных данных
    public static People createPeople() {
        Scanner scan = new Scanner(System.in);
        People human = new People();
        System.out.println("====================================================");
        System.out.println("Программа для разделения и анализа введенного текста");
        System.out.println("====================================================\n");

        String userIn, word;
        List<String> arrayHumanInfo = new ArrayList<>();
        
        while(true) {
            arrayHumanInfo.clear();
            userIn = "";
            word = "";
            
            System.out.println("Введите: Фамилию, Имя, Отчетсво, дату рождения, номер телефона и пол через пробелы в произвольном порядке! ");    
            System.out.println("/===================== Формат ввода =====================\\");            
            System.out.println("|| ФИО - Фамилия Имя Отчетство                          ||");
            System.out.println("|| Дата рождения - дд.мм.гггг                           ||");
            System.out.println("|| Номер телефона - 89991234567 (11 цифр)               ||");
            System.out.println("|| Пол - f или m                                        ||");   
            System.out.println("\\========================================================/");       
            userIn = scan.nextLine();
            if (userIn.length() == 0) { System.out.println("Повторите попытку!"); }           
            else { 
                for(int i = 0; i < userIn.length(); i++) {
                    if (i == userIn.length()-1) {
                        word += userIn.charAt(i);
                        arrayHumanInfo.add(word);
                        word = "";
                    }            
                    else if (userIn.charAt(i) != ' ') { word += userIn.charAt(i); }
                    else {
                        arrayHumanInfo.add(word);
                        word = "";
                    }
                }                
                if (arrayHumanInfo.size() == 6) { break; }
            }
        }

        for(String temp : arrayHumanInfo) {            
            if (temp != "") {
                if(temp.length() == 1 && temp.charAt(0) == 'f' || temp.length() == 1 && temp.charAt(0) == 'm') {                    
                    human.setFloor(temp);
                } else if (temp.length() == 10 && temp.charAt(2) == '.' && temp.charAt(5) == '.') {
                    human.setBirth(checkBirthDate(temp));
                } else if (temp.charAt(0) == '8' || temp.charAt(0) == '+' && temp.charAt(1) == '7') {
                    human.setPhone(checkPhone(temp));
                } else if ((temp.length() > 2 && temp.charAt(temp.length() - 2) == 'о' && temp.charAt(temp.length() - 1) == 'в') ||
                (temp.length() > 2 && temp.charAt(temp.length() - 2) == 'в' && temp.charAt(temp.length() - 1) == 'а') ||
                (temp.length() > 2 && temp.charAt(temp.length() - 2) == 'н' && temp.charAt(temp.length() - 1) == 'а') ||
                (temp.length() > 2 && temp.charAt(temp.length() - 2) == 'и' && temp.charAt(temp.length() - 1) == 'н') ||
                (temp.length() > 2 && temp.charAt(temp.length() - 2) == 'е' && temp.charAt(temp.length() - 1) == 'в')) {
                    human.setSurname(checkSurname(temp));
                } else if ((temp.length() > 3 && temp.charAt(temp.length() - 3) == 'в' && temp.charAt(temp.length() - 2) == 'и' && temp.charAt(temp.length() - 1) == 'ч') ||
                (temp.length() > 3 && temp.charAt(temp.length() - 3) == 'в' && temp.charAt(temp.length() - 2) == 'н' && temp.charAt(temp.length() - 1) == 'а')) {
                    human.setPatronymic(checkPatronymic(temp));
                } else {
                    human.setName(checkName(temp));
                }
            }
        }

        if (human.getSurname() == null || human.getSurname() == "") {
            System.out.println("В результате анализа введенных данных, фамилия не найдена!");
            while(true) {
                System.out.println("Введите фамилию: ");
                word = scan.nextLine();
                if(word.length() != 0) {
                    human.setSurname(checkSurname(word));
                    break;
                } else { System.out.println("Ошибка ввода!"); }
            }
        } 
        if (human.getName() == null || human.getName() == "") {
            System.out.println("В результате анализа введенных данных, имя не найдено!");
            while(true) {
                System.out.println("Введите имя: ");
                word = scan.nextLine();
                if(word.length() != 0) {
                    human.setName(checkName(word));
                    break;
                } else { System.out.println("Ошибка ввода!"); }
            }
        } 
        if (human.getPatronymic() == null || human.getPatronymic() == "") {
            System.out.println("В результате анализа введенных данных, отчество не найдено!");
            while(true) {
                System.out.println("Введите отчество: ");
                word = scan.nextLine();
                if(word.length() != 0) {
                    human.setPatronymic(checkPatronymic(word));
                    break;
                } else { System.out.println("Ошибка ввода!"); }
            }
        } 
        if (human.getBirth() == null || human.getBirth() == "") {
            System.out.println("В результате анализа введенных данных, дата рождения не найдена!");
            while(true) {
                System.out.println("Введите дату рождения: ");
                word = scan.nextLine();
                if (word.length() == 10 && word.charAt(2) == '.' && word.charAt(5) == '.') {
                    human.setBirth(checkBirthDate(word));
                    break;
                } else { System.out.println("Ошибка ввода!"); }
            }
        } 
        if (human.getPhone() == null || human.getPhone() == "") {
            System.out.println("В результате анализа введенных данных, номер телефона не найден!");
            while(true) {
                System.out.println("Введите номер телефона: ");
                word = scan.nextLine();                        
                if (word.charAt(0) == 8 || word.charAt(0) == '+' && word.charAt(1) == '7') {
                    human.setPhone(checkPhone(word));
                    break;                            
                } else { System.out.println("Ошибка ввода!"); }
            }
        }
        if (human.getFloor() == null || human.getFloor() == "") {
            System.out.println("В результате анализа введенных данных, пол не найден!");
            while (true) {
                System.out.println("Введите пол (f - жен / m - муж): ");
                word = scan.nextLine();
                if (word.charAt(0) == 'f' || word.charAt(0) == 'm') {
                    human.setFloor(word);
                    break;
                } else { System.out.println("Ошибка ввода!"); }
            }
        }
        scan.close();
        return human;
    }

// Проверка правильности ввода дня рождения
    public static String checkBirthDate(String birth) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Анализ введенной даты рождения...");
        
        String day, mounth, year;

        Integer d, m, y;

        String word = birth;
        String numbers = "0123456789";
        String symbols = "~`!?/@#№\"\'$;%^:&*()-_=+\\|[]{},<>";
        Map <Integer, Integer> daysMounthMap = new HashMap<>();
        daysMounthMap.put(1, 31);
        daysMounthMap.put(2, 28);
        daysMounthMap.put(3, 31);
        daysMounthMap.put(4, 30);
        daysMounthMap.put(5, 31);
        daysMounthMap.put(6, 30);
        daysMounthMap.put(7, 31);
        daysMounthMap.put(8, 31);
        daysMounthMap.put(9, 30);
        daysMounthMap.put(10, 31);
        daysMounthMap.put(11, 30);
        daysMounthMap.put(12, 31);
        
        int voln, vols, volx;

        while(true) {            
            voln = 0;
            vols = 0;
            volx = 0;
            
            day = "";
            mounth = "";
            year = "";

            d = 0;
            m = 0;
            y = 0;
            
            for(int i = 0; i < word.length(); i++) {
                for (int j = 0; j < numbers.length(); j++) {
                    if (birth.charAt(i) == numbers.charAt(j)) {
                        voln +=1;
                        break;
                    }
                }
            }
            for(int i = 0; i < word.length(); i++) {
                for (int j = 0; j < symbols.length(); j++) {
                    if (birth.charAt(i) == symbols.charAt(j)) {
                        vols +=1;
                        break;
                    }
                }
            }

            day += word.charAt(0);
            day += word.charAt(1);
            d = Integer.parseInt(day);
            mounth += word.charAt(3);
            mounth += word.charAt(4);
            m = Integer.parseInt(mounth);
            year += word.charAt(6);
            year += word.charAt(7);
            year += word.charAt(8);
            year += word.charAt(9);
            y = Integer.parseInt(year);
            
            if (y % 4 == 0) {
                for(Map.Entry<Integer, Integer> temp : daysMounthMap.entrySet()) {
                    if (temp.getKey() == 2 && temp.getValue() > 0 && temp.getValue() <= 29) {
                        volx+=1;
                        break;
                    } else if (temp.getKey() == m && d > 0 && d <= temp.getValue()) {
                        volx+=1;
                        break;
                    }
                }
            } else {
                for(Map.Entry<Integer, Integer> temp : daysMounthMap.entrySet()) {
                    if (temp.getKey() == m && d > 0 && d <= temp.getValue()) {                        
                        volx+=1;
                        break;
                    }
                }
            }            

            if (voln == 8 && vols == 0 && volx == 1) {
                break;
            } else {
                System.out.println("Введенная дата рождения не соответствует заявленным критериям оценки!");
                System.out.println("Введите дату рождения повторно: ");
                word = scan.nextLine();
            }
        }
        System.out.println("Выполнено!");        
        return word;
    }

// Проверка правильности ввода телефонного номера
    public static String checkPhone(String phone) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Анализ введенного номера телефона...");
        String word = phone;
        String numbers = "0123456789";
        int voln;
        while(true) {
            voln = 0;
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < numbers.length(); j++) {
                    if (word.charAt(i) == numbers.charAt(j)) {
                        voln +=1;
                    }
                }
            }
            if (voln == word.length()) {
                break;
            } else {
                System.out.println("Введенный телефонный номер не соответствует заявленным критериям оценки!");
                System.out.println("Введите номер повторно: ");
                word = scan.nextLine();
            }
        }
        System.out.println("Выполнено!");        
        return word;
    }

// Проверка правильности ввода фамилии
    public static String checkSurname(String surname) {        
        Scanner scan = new Scanner(System.in);
        System.out.println("Анализ введенной фамилии...");
        String word = surname;
        while(true) {
            if (checkWord(word) == word.length()) {
                break;
            } else {
                System.out.println("Введенная фамилия не соответствует заявленным критериям оценки!");
                System.out.println("Введите фамилию повторно: ");
                word = scan.nextLine();
            }
        }
        System.out.println("Выполнено!");
        return word;
    }

// Проверка правильности ввода отчества
    public static String checkPatronymic(String patronymic) {        
        Scanner scan = new Scanner(System.in);
        System.out.println("Анализ введенного отчества...");
        String word = patronymic;
        while(true) {
            if (checkWord(word) == word.length()) {
                break;
            } else {
                System.out.println("Введенное отчество не соответствует заявленным критериям оценки!");
                System.out.println("Введите отчество повторно: ");
                word = scan.nextLine();
            }
        }
        System.out.println("Выполнено!");        
        return word;
    }

// Проверка правильности ввода имени
    public static String checkName(String name) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Анализ введенного имени...");
        String word = name;
        while(true) {
            if (checkWord(word) == word.length()) {
                break;
            } else {
                System.out.println("Введенное имя не соответствует заявленным критериям оценки!");
                System.out.println("Введите имя повторно: ");
                word = scan.nextLine();
            }
        }
        System.out.println("Выполнено!");        
        return word;
    }

// Проверка текста на лишние символы
    public static int checkWord(String word) {        
        String letters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyz";
        String text = word.toLowerCase();
        int vol = 0;

        for(int i =0; i < text.length(); i++) {
            for(int j =0; j < letters.length(); j++) {
                if (text.charAt(i) == letters.charAt(j)) {
                    vol += 1;
                    break;
                }
            }
        }        
        return vol;
    }

}