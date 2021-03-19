package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hospital {
    private final boolean open;
    private final int personal;
    private final String department;
    private final Surgeon surgeon;
    private final String[] employee;

    public Hospital(boolean open, int personal, String department,
                    Surgeon surgeon, String[] employee) {
        this.open = open;
        this.personal = personal;
        this.department = department;
        this.surgeon = surgeon;
        this.employee = employee;
    }

    public boolean isOpen() {
        return open;
    }

    public int getPersonal() {
        return personal;
    }

    public String getDepartment() {
        return department;
    }

    @JSONPropertyIgnore
    public Surgeon getSurgeon() {
        return surgeon;
    }

    public String[] getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "Hospital{"
                + "open=" + open
                + ", personal=" + personal
                + ", department='" + department + '\''
                + ", surgeon=" + surgeon
                + ", employee=" + Arrays.toString(employee)
                + '}';
    }

    public static void main(String[] args) {
        final Hospital hospital = new Hospital(true, 30, "Surgeon",
                new Surgeon(12), new String[] {"Петров", "Федоров"});

        JSONObject jsonSurgeon = new JSONObject("{\"experience\":\"12\"}");

        List<String> list = new ArrayList<>();
        list.add("Петров");
        list.add("Федоров");
        JSONArray jsonEmployee = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("open", hospital.isOpen());
        jsonObject.put("personal", hospital.getPersonal());
        jsonObject.put("department", hospital.getDepartment());
        jsonObject.put("surgeon", jsonSurgeon);
        jsonObject.put("statuses", jsonEmployee);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(hospital).toString());
    }
}
