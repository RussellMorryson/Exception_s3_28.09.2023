import java.util.List;
import java.util.Scanner;

//String alphabet = "абвгдеёжзийклмнопрстуфхцшщчъыьэюяabcdefghijklmnopqrstuvwxyz";

class Task {
    public static void main (String [] args) {      
       //List <Integer> array  = userInput ();
       
    }   
    // Метод для проверки текста на наличие цифр и символов
    public bool checkText(String text) {
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
        return strlen == 0;
    }
 
    // Метод для проработки ошибок ввода фамилии
    public String checkSurname() {
        Scanner scan = new Scanner(System.in); 
        String userInput, surEnd, accept;
        bool approve = true;
        while (approve) {
            System.out.println("Повторно введите фамилию: ");
            userInput = scan.nextLine();            
            surEnd = userInput.charAt(userInput.length() - 1) + userInput.charAt(userInput.length() - 2);
            if (surEnd == "ов" || surEnd == "ва" || surEnd == "на" || surEnd == "ин" || surEnd == "ев") {
                if (checkText(userInput)) {
                    p.setSurname(userInput);
                    break;                    
                } else {
                    System.out.println("В тексте имеются посторонние символы\n");
                }
            } else {
                System.out.println("Введенный текст " + userInput + " не является фамилией в результате анализа имеющихся критерий!\n");                
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
    public String checkPatronymic() {
        Scanner scan = new Scanner(System.in); 
        String userInput, patroEnd, accept;
        bool approve = true;
        while (approve) {
            System.out.println("Повторно введите отчество: ");
            userInput = scan.nextLine();
            patroEnd = userInput.charAt(userInput.length() - 1) + userInput.charAt(userInput.length() - 2) + userInput.charAt(userInput.length() - 3); 
            if (patroEnd == "вич" || patroEnd == "вна") {
                if (checkText(userInput)) {
                    p.setSurname(userInput);
                    break;
                } else {
                    System.out.println("В тексте имеются посторонние символы\n");
                }
            } else {
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
    public String checkBirth(String text) {
        Scanner scan = new Scanner(System.in);
        int point





        scan.close();        
        return text;
    }

    // Метод для обработки ошибок ввода номера телефона
    public String checkPhone() {
        Scanner scan = new Scanner(System.in); 
        List <Character> arrnums = {'0','1','2','3','4','5','6','7','8','9'};       
        String userInput;
        int volume;
        bool accept = true;

        while(accept) {
            System.out.println("Номер телефона состоит из 11 цифр и начинается с 8 или +7! \n");
            System.out.println("Повторно введите номер телефона: \n");
            userInput = scan.nextLine();
            if ((userInput.length() == 10 && userInput.charAt(0) == '8') ||                                     
            (userInput.length() == 10 && userInput.charAt(0) + userInput.charAt(1)== "+7")) {
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
    }


    // Метод для обработки ошибок ввода имени




    // Основной запускаемый метод с ответвлениями
    public void userInput () {
        Scanner scan = new Scanner(System.in); 
        List<String> arrList = new ArrayList();
        People p = new People();

        List <Character> arrnums = {'0','1','2','3','4','5','6','7','8','9'};

        



        
        String inputText, text = "";
        bool access = true;        
        int volume = 0;        
        while (access) {
            System.out.println("Введите в произвольном порядке ФИО, дату рождения, номер телефона и пол через пробелы в формате: \n");
            System.out.println("ФИО - Фамилия Имя Отчетство \n");
            System.out.println("Дата рождения - дд.мм.гггг \n");
            System.out.println("Номер телефона - 89991234567 \n");
            System.out.println("Пол - f или m \n");
            
            inputText = scan.nextLine(); 
            if (inputText == "") {
                System.out.println("Ошибка! Ничего не введено!\nПовторите попытку!\n");                
                break;
            } else {
                // Извлечение из текста информации и перенос ее в массив arrList                 
                for (int i = 0; i < inputText.length(); i++) {
                    if (inputText.charAt(i) != ' ') { 
                        text +=inputText.charAt(i);
                    } else {
                        arrList.add(text);
                        text = "";
                        vol += 1;
                    }
                } 
                if (arrList != 6) {
                    System.out.println("Ошибка ввода!\nВведены не все запрашиваемые элементы!\n");
                    break;
                } else {                    
                    // Рассмотрение каждого элемента массива 
                    String sur, patro = "";
                    for(String temp : arrList) {      
                        sur = temp.charAt(temp.length() - 1) + temp.charAt(temp.length() - 2);
                        patro = ttemp.charAt(temp.length() - 1) + temp.charAt(temp.length() - 2) + temp.charAt(temp.length() - 3);                        
                        //Проверка элемента на совпадение с критериями определения фамилии
                        if (sur == "ов" || sur == "ва" || sur == "на" || sur == "ин" || sur == "ев") {
                            if (checkText(temp)) {
                                p.setSurname(temp);
                                arrList.remove(h);
                            } else {
                                System.out.println("В тексте имеются посторонние символы\n");
                                p.setSurname(checkSurname());
                                arrList.remove(h);
                            }
                        // Проверка элемента на совпадение с критериями определения отчества
                        } else if (patro == "вич" || patro == "вна") {
                            if (checkText(temp)) {
                                p.setPatronymic(temp);
                                arrList.remove(h);
                            } else {
                                System.out.println("В тексте имеются посторонние символы\n");
                                p.setPatronymic(checkPatronymic());
                                arrList.remove(h);
                            }
                        // Проверка элемента на совпадение с критериями определения даты рождения
                        } else if ((temp.length() == 10 && temp.charAt(2) == '.' && temp.charAt(5) == '.') ||                                     
                            (temp.length() == 10 && temp.charAt(2) == '.' && temp.charAt(7) == '.') ||                                     
                            (temp.length() == 10 && temp.charAt(4) == '.' && temp.charAt(7) == '.') ) {
                                p.setPhone(checkBirth(temp));
                                arrList.remove(h);
                        
                        // Проверка элемента на совпадение с критериями определения номера телефона       
                        } else if ((temp.length() == 10 && temp.charAt(0) == '8') ||                                     
                            (temp.length() == 10 && temp.charAt(0) + temp.charAt(1) == "+7")) {
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
                                arrList.remove(h);
                            } else {
                                System.out.println("В введенном номере телефона: " + temp + ". имеются посторонние символы\n");
                                p.setPhone(checkPhone());
                                arrList.remove(h);
                                volume = 0;
                            }
                        }
                    }
                    scan.close();  
                }
            }
        }
    }
}
