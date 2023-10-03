import java.util.*;

public class Task_x {
    public void main (String [] args) {
        People p = new People();
        p = createPeople();
    }

    public People createPeople() {
        Scanner scan = new Scanner(System.in);
        People human = new People();
        System.out.println("====================================================");
        System.out.println("Программа для разделения и анализа введенного текста");
        System.out.println("====================================================\n");

        String userIn, word, surEnd, patroEnd;
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
            System.out.println("|| Пол - f или m                                        ||\n");   
            System.out.println("\\========================================================/");       
            userIn = scan.nextLine();
            if (userIn.length() == 0) { System.out.println("Повторите попытку!"); }           
            else { 
                for(int i = 0; i < userIn.length(); i++) {
                    if (i == userIn.length()-1) {
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

            for(String temp : arrayHumanInfo) {
                surEnd = "";
                surEnd += temp.charAt(temp.length() - 1);
                surEnd += temp.charAt(temp.length() - 2);

                patroEnd = "";
                patroEnd += temp.charAt(temp.length() - 1);
                patroEnd += temp.charAt(temp.length() - 2);
                patroEnd += temp.charAt(temp.length() - 3);

                if(temp.length() == 1 && temp == "f" || temp.length() == 1 && temp == "m") {
                    human.setFloor(temp);
                } else if (temp.length() == 10 && temp.charAt(2) == '.' && temp.charAt(5) == '.') {
                    human.setBirth(checkBirthDate(temp));
                } else if (temp.charAt(0) == '8' || temp.charAt(0) == '+' && temp.charAt(1) == '7') {
                    human.setPhone(checkPhone(temp));
                } else if (surEnd == "ов" || surEnd == "ва" || surEnd == "на" || surEnd == "ин" || surEnd == "ев") {
                    human.setSurnamee(checkSurname(temp));
                } else if (patro == "вич" || patro == "вна") {
                    human.setPatronymic(checkPatronymic(temp));
                } else {
                    human.setName(checkName(temp));
                }

                if (human.getSurname() == "") {
                    System.out.println("В результате анализа введенных данных, фамилия не найдена!");
                    System.out.println("Введите фамилию: ");
                    word = scan.nextLine();
                    human.setSurnamee(checkSurname(temp));
                } else if (human.getName() == "") {
                    System.out.println("В результате анализа введенных данных, имя не найдено!");
                    System.out.println("Введите имя: ");
                    word = scan.nextLine();
                    human.setName(checkName(temp));
                } else if (human.getPatronymic() == "") {
                    System.out.println("В результате анализа введенных данных, отчество не найдено!");
                    System.out.println("Введите отчество: ");
                    word = scan.nextLine();
                    human.setPatronymic(checkPatronymic(temp));
                } else if (human.getBirth() == "") {
                    System.out.println("В результате анализа введенных данных, дата рождения не найдено!");
                    System.out.println("Введите дату рождения: ");
                    word = scan.nextLine();
                    human.setBirth(checkBirthDate(temp));
                } else if (human.getPhone() == "") {
                    System.out.println("В результате анализа введенных данных, номер телефона не найден!");
                    while(true) {
                        System.out.println("Введите номер телефона: ");
                        word = scan.nextLine();
                        if (word.length() != 11) {
                            System.out.println("Ошибка ввода! (количество элементов меньше 11)");
                        } else if (word.length() == 0 ) {
                            System.out.println("Ошибка ввода!");
                        } else {
                            human.setPhone(checkPhone(temp));
                        }                        
                    }
                } else if (human.getFloor() == "") {
                    System.out.println("В результате анализа введенных данных, пол не найден!");
                    while (true) {
                        System.out.println("Введите пол (f - жен / m - муж): ");
                        word = scan.nextLine();
                        if (word == "f" || word == "m") {
                            human.setFloor(temp);
                            break;
                        } else {
                            System.out.println("Ошибка ввода!");
                        }
                    }                    
                }
            }
        }     
        scan.close();
        return human; 
    }

// Проверка правильности ввода дня рождения
    public String checkBirthDate(String birth) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Анализ введенной даты рождения...");
        
        String day, mounth, year;

        int d, m, y;

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

            day += word.charAt(0) + word.charAt(1);
            d = Integer.parseInt(day);
            mounth += word.charAt(3) + word.charAt(4);
            m = Integer.parseInt(mounth);
            year += word.charAt(6) + word.charAt(7) + word.charAt(8) + word.charAt(9);
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

            if (voln == 8 && vols ==0 && volx == 1) {
                break;
            } else {
                System.out.println("Введенная дата рождения не соответствует заявленным критериям оценки!");
                System.out.println("Введите дату рождения повторно: ");
                word = scan.nextLine();
            }
        }
        System.out.println("Выполнено!");
        scan.close();
        return word;
    }

// Проверка правильности ввода телефонного номера
    public String checkPhone(String phone) {
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
        scan.close();
        return word;
    }

// Проверка правильности ввода фамилии
    public String checkSurname(String surname) {        
        System.out.println("Анализ введенной фамилии...");
        String word = surname;
        while(true) {
            if (checkWord{word} == word.length()) {
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
    public String checkPatronymic(String patronymic) {        
        System.out.println("Анализ введенного отчества...");
        String word = patronymic;
        while(true) {
            if (checkWord{word} == word.length()) {
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

    public String checkName(String name) {
        System.out.println("Анализ введенного имени...");
        String word = name;
        while(true) {            
            if (checkWord{word} == word.length()) {
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

    public int checkWord(String word) {
        Scanner scan = new Scanner(System.in);
        String letters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String text = word;
        int vol = 0;

        for(int i =0; i < word.length(); i++) {
            for(int j =0; j < letters.length(); j++) {
                if (word.charAt(i) == letters.charAt(j)) {
                    vol += 1;
                     break;
                }
            }
        }
        scan.close();
        return vol;
    }
}
