# Flashlight-App
This project demonstrates how to build a simple **Flashlight (TorchLight) Android application** using **Java in Android Studio**. The app allows users to turn the device flashlight **ON and OFF** using a ToggleButton.

---

## 📱 Project Overview
The Flashlight app uses the **device camera flash** to provide light.  
A **ToggleButton** is used to control the flashlight state.

When the toggle button is:
- **ON** → Flashlight turns ON  
- **OFF** → Flashlight turns OFF  

---

## 🛠 Requirements
- Android Studio
- Android SDK
- Android Device with Flashlight
- Programming Language: **Java**

---

## 📌 Steps for Building the Application

### Step 1: Create a New Project
1. Open **Android Studio**.
2. Click **New Project**.
3. Select **Empty Activity**.
4. Set project details:
   - **Project Name:** FlashlightApp
   - **Language:** Java
   - **Minimum SDK:** API 21 or higher
5. Click **Finish**.

---

### Step 2: Design the Layout (activity_main.xml)

This layout contains:
- A **TextView** for the title
- A **View** as a divider
- A **ToggleButton** to control the flashlight
