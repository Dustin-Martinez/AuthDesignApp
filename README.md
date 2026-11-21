
# AuthDesignApp — Student Portal Authentication & Profile Dashboard

A native Android mobile application built in Kotlin and XML using Material Design 3. Developed as an App Development laboratory activity, this project implements a complete student authentication flow—featuring user registration, credential validation, local data persistence, and a structured student academic profile dashboard.

## Overview & Core Features

- **User Authentication (`MainActivity`)**: Clean Material 3 sign-in interface with outlined text fields, password visibility toggles, input validation, and an automatic demo-mode fallback when no local account has been registered yet.
- **Student Registration (`SignupActivity`)**: Account creation form capturing login credentials alongside student identity and academic details (Student Number, Last Name, First Name, Program, Specialty, and Year Level).
- **Academic Profile Dashboard (`DashboardActivity`)**: Displays a deep-navy header banner formatted with the student's full name (`Last Name, First Name`) and Student Number badge, paired with an overlapping Material card presenting their Program, Specialty, and Year Level.
- **Local Data Persistence & Backup Rules**: Stores user profiles locally via Android `SharedPreferences` (`StudentPrefs`) and excludes credential files from cloud backups and device transfers using `backup_rules.xml` and `data_extraction_rules.xml`.

## Tech Stack

- **Language**: Kotlin
- **UI & Layout**: Android XML Views, Material Components for Android (Material 3), `ScrollView`, `LinearLayout`, `MaterialCardView`, `TextInputLayout`
- **Storage**: Android `SharedPreferences`
- **Build System**: Gradle (Kotlin DSL — `build.gradle.kts`)
- **IDE & Version Control**: Android Studio, Git & GitHub

## Project Structure

```text
app/src/main/
├── java/com/example/authdesignapp/
│   ├── MainActivity.kt          # Login screen & authentication logic
│   ├── SignupActivity.kt        # Registration form & SharedPreferences storage
│   └── DashboardActivity.kt     # Student profile & academic info display
├── res/
│   ├── layout/
│   │   ├── activity_main.xml        # Login UI layout
│   │   ├── activity_signup.xml      # Registration UI layout
│   │   └── activity_dashboard.xml   # Student dashboard UI layout
│   ├── values/
│   │   └── themes.xml               # Material 3 NoActionBar theme & color palette
│   └── xml/
│       ├── backup_rules.xml         # Auto-backup exclusion rules (< API 31)
│       └── data_extraction_rules.xml# Cloud backup & transfer rules (API 31+)
└── AndroidManifest.xml              # Activity declarations & soft-input config

```

## Getting Started

1. **Clone the repository**
```bash
git clone [https://github.com/Dustin-Martinez/AuthDesignApp.git](https://github.com/Dustin-Martinez/AuthDesignApp.git)

```


2. **Open in Android Studio**
* Launch Android Studio and select **File > Open**, then choose the cloned `AuthDesignApp` folder.
* Wait for Gradle sync to finish.


3. **Run the Application**
* Select an Android Emulator (e.g., Medium Phone API 37) or connect a physical Android device with USB Debugging enabled.
* Click **Run** (`Shift + F10`).



## Usage

* **Quick Demo Login**: On first launch (before registering an account), enter any non-empty username and password to preview the dashboard with a pre-configured default student profile.
* **Custom Account Flow**: Tap **Create Account** on the login screen, complete all registration fields, and sign in with your newly created credentials to view your custom profile.

## Author

**Kit Dustin Perez Martinez**

BS Computer Science — Digital Forensics

National University Manila
