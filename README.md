# TSC Blutooth Printer

TSC Barcode &amp; QR Code Print

#Android Permissions 
```
   <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
```
# Using Extranal TSC Android SDK


# Android SDK Link

https://www.tscprinters.com/EN/support/Support_Download/ML240%20Series

# Code
```
        TSCActivity TscDll = new TSCActivity()
        TscDll.openport("00:19:0E:A3:79:DD");
        TscDll.downloadpcx("UL.PCX");
        TscDll.downloadbmp("Triangle.bmp");
        TscDll.downloadttf("ARIAL.TTF");
        TscDll.setup(30, 30, 4, 4, 0, 0, 0);
        TscDll.clearbuffer();
        TscDll.sendcommand("SET TEAR ON\n");
        TscDll.sendcommand("SET COUNTER @1 1\n");
        TscDll.sendcommand("@1 = \"0001\"\n");
        TscDll.sendcommand("TEXT 100,300,\"3\",0,1,1,@1\n");
        TscDll.sendcommand("PUTPCX 100,300,\"UL.PCX\"\n");
        TscDll.sendcommand("PUTBMP 100,520,\"Triangle.bmp\"\n");
        TscDll.sendcommand("TEXT 100,760,\"ARIAL.TTF\",0,15,15,\"THIS IS ARIAL FONT\"\n");
       // TscDll.sendcommand("QRCODE 50,50,H,4,A,0,M2,S7,\"123TSCtest\"\n");
        //TscDll.barcode(100, 100, "128", 100, 1, 0, 3, 3, "123456789");
        TscDll.printerfont(100,40, "0", 0, 14, 14, "Aher");
        TscDll.qrcode(15,90,"H","4","A","0","M2","S7","N123");
        TscDll.printerfont(20,200, "0", 0, 12, 12, "Aher");
        String status = TscDll.status();
        System.out.println("Status : "+status);
        TscDll.printlabel(1, 1);
        TscDll.sendfile("zpl.txt");
      TscDll.closeport();
``` 
