# android-introduction
This project was create to learn more about android and how to develop a native project for android devices.


# What is Android ? 
- An operational system open source, based on linux

# Where is Android used ?
- Smartphones and tablets.
- Wears (SmartWatches)
- TVs
- Laptops
- Cars
- IoT (Raspi)

# Main advantages when developing to android
- Wide range of users
- More possibilities to use when talking about the software/hardwares features of android devices like : 
  -  Camera
  -  GPS
  -  Sensors
  -  Connectivity

# Starting 
- **Registering the Main/Launcher Activity on the AndroidManifest.xml**
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.vhbeltramini.agenda">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Agenda">
        <activity android:name=".MainActivity" android:exported="true" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
</manifest>
```
