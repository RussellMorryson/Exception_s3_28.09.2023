class People {
    // Основные переменные
    private String name;        // Имя
    private String surname;     // Фамилия
    private String patronymic;  // Отчество
    private String birth;       // Дата рождения
    private String phone;       // Телелфонный номер
    private String floor;         // Пол

    // Методы для возврата значений информации о человеке
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPatronymic() { return patronymic; }
    public String getBirth() { return birth; }
    public String getPhone() { return phone; }
    public String getFloor() { return floor; }

    // Методы для установления и корректировки информации о человеке
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public void setBirth(String birth) { this.birth = birth; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setFloor(String floor) { this.floor = floor; }

    // Основной конструктор
    public People(String name, String surname, String patronymic, String birth, String phone, String floor) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birth = birth;
        this.phone = phone;
        this.floor = floor;
    }
     public People() {        
    }

    // Возвращение всей информации в виде текста
    public String allInfo(){
        return "<" + name + ">" + 
               "<" + surname + ">" + 
               "<" + patronymic + ">" + 
               "<" + birth + ">" + 
               "<" + phone + ">" + 
               "<" + floor+ ">"; 
    }

    // Вывод в консоль всей информации
    public void printAllInfo(){
        System.out.println("<" + this.name + ">" + 
                           "<" + this.surname + ">" + 
                           "<" + this.patronymic + ">" + 
                           "<" + this.birth + ">" + 
                           "<" + this.phone + ">" + 
                           "<" + this.floor+ ">");
    }
}