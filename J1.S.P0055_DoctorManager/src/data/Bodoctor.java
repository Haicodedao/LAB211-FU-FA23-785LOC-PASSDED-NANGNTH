package data;

import data.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bodoctor {

    private HashMap<String, Doctor> doctorHashMap;

    public Bodoctor() {
        doctorHashMap = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctor == null || doctor.getCode() == null) {
            throw new Exception("Data does not exist");
        }
        doctorHashMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor updatedDoctor) throws Exception {
        if (updatedDoctor == null || updatedDoctor.getCode() == null) {
            throw new Exception("Data does not exist");
        }

        if (doctorHashMap.containsKey(updatedDoctor.getCode())) {
            doctorHashMap.put(updatedDoctor.getCode(), updatedDoctor);
        }
        return true;
    }

    public boolean deleteDoctor(String code) throws Exception {
        if (doctorHashMap.containsKey(code)) {
            doctorHashMap.remove(code);
            return true;
        } else if (doctorHashMap.isEmpty()) {
            throw new Exception("List empty");
        } else {
            throw new Exception("Doctor with code " + code + " does not exist");
        }
    }

    public HashMap<String, List<Doctor>> searchDoctor(String searchText) {
        HashMap<String, List<Doctor>> result = new HashMap<>();

        List<Doctor> doctorList = new ArrayList<>();
        for (Doctor doctor : doctorHashMap.values()) {
            if (doctor.getCode().trim().contains(searchText) || doctor.getName().trim().contains(searchText)) {
                doctorList.add(doctor);
            }
        }

        if (searchText.isEmpty()) {
            result.put("", new ArrayList<>(doctorHashMap.values()));
        } else {
            result.put(searchText, doctorList);
        }
        return result;
    }

    public HashMap<String, List<Doctor>> searchToUpdate(String code) {
        HashMap<String, List<Doctor>> result = new HashMap<>();

        List<Doctor> doctorList = new ArrayList<>();
        for (Doctor doctor : doctorHashMap.values()) {
            if (doctor.getCode().trim().equalsIgnoreCase(code)) {
                doctorList.add(doctor);
                result.put(code, doctorList);
            }
        }
        return result;
    }

    public boolean checkCodeDup(String code) {
        for (Map.Entry<String, Doctor> entry : doctorHashMap.entrySet()) {
            String key = entry.getKey();
            if (doctorHashMap.containsKey(code)) {
                return true;
            }
        }
        return false;
    }
}
