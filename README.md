# flutter_web_browser

[![Pub](https://img.shields.io/pub/v/flutter_web_browser.svg)](https://pub.dartlang.org/packages/flutter_web_browser)

A flutter plugin to open a web page with [Chrome Custom Tabs](https://developer.chrome.com/multidevice/android/customtabs) & [SFSafariViewController](https://developer.apple.com/documentation/safariservices/sfsafariviewcontroller).

This plugin is under development, APIs might change.

## Getting Started

#### Installation
nstall the library from pub:
```
dependencies:
  flutter_web_browser: "^0.12.0"
```


#### Import the library
```
import 'package:flutter_web_browser/flutter_web_browser.dart';
```

##### Open the web page
```
FlutterWebBrowser.openWebPage(
  url: "https://flutter.io/",
  androidToolbarColor: Colors.deepPurple,
  safariVCOptions: SafariViewControllerOptions(
    barCollapsingEnabled: true,
    preferredBarTintColor: Colors.green,
    preferredControlTintColor: Colors.amber,
    dismissButtonStyle: SafariViewControllerDismissButtonStyle.close,
    modalPresentationCapturesStatusBarAppearance: true,
  ),
);
```


## License
This project is licensed under the terms of the MIT license.
