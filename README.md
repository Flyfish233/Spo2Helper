# Spo2 Helper

![Logo](https://raw.githubusercontent.com/Flyfish233/Spo2Helper/main/screenshot/ic_launcher_round.png)

[English](https://github.com/Flyfish233/Spo2Helper/new/main?readme=1#english)

### 三星手表血氧监控助手。

## 用途

此 App 可以自动唤起三星手表 (Galaxy Watch 4+) 上的血氧测试程序，达到半自动化的血氧测试效果。

受三星局限性影响（请见下文），使用此程序时可能经常出现测试失败的问题，因此 App 仅供用户在卧床或者坐下办公时才有更好的效果。

安装手机和手表端。不需要预先打开手表端，只需确保手机已经蓝牙连接手表（或通过 Google Cloud Sync）

- 点击手机上的血氧测试按钮。手表将会立即开始测量血氧，适用于远程控制和监视。

- 输入时长并进行血氧监测。您的手机将每隔一段时间发送一次血氧测试。默认为 10 分钟。

  ###### 您需要在三星健康 App 中查看测量好的血氧。

## 截图

![CN](https://raw.githubusercontent.com/Flyfish233/Spo2Helper/main/screenshot/studio64.png)

## 限制

受三星和 GDPR 等隐私政策影响，普通软件不得调用和查看这些传感器的敏感数据，只有受审查的医疗健康开发团队可以进行申请一个私有的 SDK，借此获取传感器数据。查看 [Samsung Health Privileged SDK](https://developer.samsung.com/health/privileged)。

该 SDK 并未公开发布，且需要额外的 API 和 Key 才可以被使用，例如使用该 API 的 [Samsung Health Monitor](https://www.samsung.com/hk/apps/samsung-health-monitor/)。

## 致谢

代码写的非常烂，能跑就行。用脚写的，所以很对不起

**图标来源：**

[木子家的小团子](https://www.iconfont.cn/user/detail?uid=5049874&nid=fZ6DpMNcJqzs)

**软件基于此通信组件运行：**

[Wear Msger](https://github.com/ichenhe/Wear-Msger)

## English

### A simple tool for monitoring blood oxygen with Samsung Galaxy Watch.

## Usage

It automatically launches the blood oxygen test app on the Samsung Galaxy Watch (4+) for a semi-automated blood oxygen test.

Due to Samsung limitations (see below), there may be frequent test failures when using this app, so the app is only intended to work better when the user is in bed or sitting down.

​			Install phone and watch apks. There is no need to pre-open the watch app, just make sure the phone is connected to the watch via Bluetooth (or via Google Cloud Sync)

- Click the **Send Spo2 Test** button on the phone. The watch will immediately start measuring blood oxygen, suitable for remote control and monitoring.

- Enter the duration and perform blood oxygen monitoring. Your phone will send blood oxygen tests at regular intervals. Default is 10 minutes.

  ###### View the measured blood oxygen in the Samsung Health App.

## Screenshot

![EN](https://raw.githubusercontent.com/Flyfish233/Spo2Helper/main/screenshot/studio64en.png)

## Limitations

Due to privacy policies such as Samsung and GDPR, Developers is not allowed to view sensitive data from these sensors, and only vetted healthcare teams can apply for a private SDK to access sensor data. View [Samsung Health Privileged SDK](https://developer.samsung.com/health/privileged).

## Acknowledgements

The code is shitty and Can Run Just Fine.

**Icon by:**

[木子家的小团子](https://www.iconfont.cn/user/detail?uid=5049874&nid=fZ6DpMNcJqzs)

**Based on:**

[Wear Msger](https://github.com/ichenhe/Wear-Msger)
