# react-native-gotoactivity-android
a react-native goto activity 


## Example

```js
'use strict';

var React = require('react-native');
var {
  AppRegistry,
  StyleSheet,
  Text,
  Dimensions,
  ToastAndroid,
  View,
} = React;

var gotoactivity = require('react-native-gotoactivity-android');
var deviceWidth = Dimensions.get('window').width;
var deviceHeight = Dimensions.get('window').height;

var ReactNativeSegmentedExample = React.createClass({
   _onPressButton:function(){
       // GoToActivity.gotoActivity();
      GoToActivity.gotoActivityFunc(function(backData){
          ToastAndroid.show('backData=== '+backData, ToastAndroid.SHORT)
      }); 
   },
  render: function() {
    return (
      renderButton: function() {
        return (
          <TouchableHighlight onPress={this._onPressButton}>
            <Text style={{width:deviceWidth,height:50}}>click goto activity</Text>
          </TouchableHighlight>
        );
      },
    );
  }
});

```

## Install

### Step 1 - Install the npm package

```sh
$ npm install react-native-gotoactivity-android --save
```

### Step 2 - Update Gradle Settings

```gradle
// file: android/settings.gradle
...

include ':react-native-gotoactivity-android', ':app'
project(':react-native-gotoactivity-android').projectDir = new File(rootProject.projectDir,'../node_modules/react-native-gotoactivity-android')
```

### Step 3 - Update app Gradle Build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':react-native-gotoactivity-android')
}
```

### Step 4 - Register React Package

```java
...
import com.higo.zhangyp.gotoactivity.GoToActivityPackage; // <-- import

public class MainActivity extends FragmentActivity implements DefaultHardwareBackBtnHandler {

    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new GoToActivityPackage(this,ExampleActivity.class)) // <-- Register package here and goto yout ExampleActivity
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", null);
        setContentView(mReactRootView);
    }
...
