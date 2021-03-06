import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_web_browser/flutter_web_browser.dart';

void main() {
  runApp(new MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => new _MyAppState();
}

class _MyAppState extends State<MyApp> {
  openBrowserTab() async {
    await FlutterWebBrowser.openWebPage(
        url: "https://flutter.io/", androidToolbarColor: Colors.deepPurple);
  }

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Plugin example app'),
        ),
        body: new Center(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: <Widget>[
              RaisedButton(
                onPressed: () => openBrowserTab(),
                child: new Text('Open Flutter website'),
              ),
              if (Platform.isIOS) ...[
                Text('test iOS customizations'),
                RaisedButton(
                  onPressed: () {
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
                  },
                  child: Text('Open Flutter website'),
                ),
              ]
            ],
          ),
        ),
      ),
    );
  }
}
