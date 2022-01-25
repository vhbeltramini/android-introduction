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
# Examples

- Creating a simple List with a bottom on the Screen
```xml
<?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"
        >

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/activity_main_button_new_student"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentBottom="true"
        android:layout_marginEnd="26dp"
        android:layout_marginBottom="26dp"
        android:clickable="true" />

    <ListView
        android:id="@+id/activity_main_list_students"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </ListView>
</RelativeLayout>
```
