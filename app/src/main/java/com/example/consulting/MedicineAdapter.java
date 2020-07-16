package com.example.consulting;

public class MedicineAdapter {

    String MedicineName;
    String MedicineProperties;
    String MedicineFunction;
    String MedecineDetail;

    public MedicineAdapter(){

    }

    public MedicineAdapter(String medicineName, String medicineProperties, String medicineFunction, String medecineDetail) {
        MedicineName = medicineName;
        MedicineProperties = medicineProperties;
        MedicineFunction = medicineFunction;
        MedecineDetail = medecineDetail;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public String getMedicineProperties() {
        return MedicineProperties;
    }

    public String getMedicineFunction() {
        return MedicineFunction;
    }

    public String getMedecineDetail() {
        return MedecineDetail;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public void setMedicineProperties(String medicineProperties) {
        MedicineProperties = medicineProperties;
    }

    public void setMedicineFunction(String medicineFunction) {
        MedicineFunction = medicineFunction;
    }

    public void setMedecineDetail(String medecineDetail) {
        MedecineDetail = medecineDetail;
    }
}
