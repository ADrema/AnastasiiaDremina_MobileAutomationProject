# AnastasiiaDremina_MobileAutomationProject
Homework3
1.	Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?
The only one driver instance is created at the moment.
No ability to execute tests in parallel, but this is not required
2.	Suggest improvements for .properties reading. What are the purposes?
The property can be defined directly from test:
	Before class with prepareDriver() method is moved to test;
	Enum is set as a parameter for prepareDriver() method;
3.	Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test
4.	Optional: Add keyboard presence check  in “native” test.
5.	Which checks would you place in the “web” test?
-	Url
-	Page Title
-	Response code (Need additional libraries, no ability to do it only with selenium)
6.	Implement checks for “web” test in code and try to use.

Homework2
1.	Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.
2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?
Additional row “Using%” in logs, collected by Appium in case of defining by ID or ClassName	 
Xpath = //android.widget.Button[@content-desc="Add Contact"]
ID  = com.example.android.contactmanager:id/addContactButton
[[BOOTSTRAP LOG] [debug] Using: UiSelector[INSTANCE=0, RESOURCE_ID=com.example.android.contactmanager:id/addContactButton]
ClassName = android.widget.Button
[BOOTSTRAP LOG] [debug] Using: UiSelector[CLASS=android.widget.Button, INSTANCE=0]

3.	Modify existing tests to run on a real device. What should be changed? 
Actually, you should do nothing.
If the real android device will be the single in the list available devices.
You can use settings for Native devices without changing the deviceName(bug or feature?)
Normally, you should change deviceName to real device number (adb devices, when the Android device will be connected to PC)
4.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?
Firstly, necessary to switch on Developer mode (Settings > About device > Software Info Press Build Number 7 times)
Secondly, you need to enable some additional functions in Developer options screen
-	Enable “Debugging”
-	Enable “USB debugging
In addition, change “USB configuration” to MTP
In case you cannot recognize your device on PC move “USB configuration” to PTP
than it will be automatically changed to MTP (respective value)

During the first executions, you will have to allow installation of the following applications:
- Appium Settings
- Unlock
- ContactManager


5.	What should be improved/changed in existing test code? Why, for what?
-	Divide test-cases with different purposes(native/web) to different packages and classes to avoid the mess.
-	Different Preparation settings should also be moved to different classes/packages with the proper names
-	Thread Sleeps should be removed from Code (Real-Time testing)
-	Hardcoded values(Really difficalt to support/ All Data should be moved to Data file)
-	Absolute paths (Not portable)
-	Descriptions should be added  for every method to get clear information about code
-	Test-cases		 should be created(The main purpose for Testing)
