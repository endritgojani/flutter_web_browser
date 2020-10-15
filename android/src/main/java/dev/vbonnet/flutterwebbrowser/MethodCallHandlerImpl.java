package dev.vbonnet.flutterwebbrowser;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.webkit.WebView;

import androidx.browser.customtabs.CustomTabsIntent;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class MethodCallHandlerImpl implements MethodCallHandler {

  private Activity activity;

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method) {
      case "openWebPage":
        openUrl(call, result);
        break;
      default:
        result.notImplemented();
        break;
    }
  }

  private void openUrl(MethodCall call, Result result) {
    if (activity == null) {
      result.error("no_activity", "Plugin is only available within a activity context", null);
      return;
    }
    String url = call.argument("url");
    String toolbarColorArg = call.argument("android_toolbar_color");

    WebView webView = new WebView(activity);
    webView.getSettings().setJavaScriptEnabled(true);
    String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
    webView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);



//
//    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
//    if (toolbarColorArg != null) {
//      int toolbarColor = Color.parseColor(toolbarColorArg);
//      builder.setToolbarColor(toolbarColor);
//    }
//    CustomTabsIntent customTabsIntent = builder.build();
//    customTabsIntent.launchUrl(activity, Uri.parse("https://drive.google.com/viewerng/viewer?embedded=true&url="+url));

    result.success(null);
  }
}
