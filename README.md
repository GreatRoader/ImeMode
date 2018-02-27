### 通过监测根布局位置变化来判断输入法的显示与隐藏
 1. 将InputSoftRelativeLayout作为输入法页面的根布局
 2. 在Activity中设置监听即可 mRootLayout.setSoftKeyboardListener

The display and hiding of input method can be determined by monitoring the change of root layout position.
1. Use the InputSoftRelativeLayout as the root layout of the input method page.
2. In the Activity can be set up to monitor mRootLayout. SetSoftKeyboardListener