Protocol Buffers - Google's data interchange format
Copyright 2008 Google Inc.
https://developers.google.com/protocol-buffers/

This package contains a precompiled binary version of the protocol buffer
compiler (protoc). This binary is intended for users who want to use Protocol
Buffers in languages other than C++ but do not want to compile protoc
themselves. To install, simply place this binary somewhere in your PATH.

If you intend to use the included well known types then don't forget to
copy the contents of the 'include' directory somewhere as well, for example
into '/usr/local/include/'.

Please refer to our official github site for more installation instructions:
  https://github.com/protocolbuffers/protobuf

插件下载地址：
https://github.com/protocolbuffers/protobuf/releases





进入到 protoc.exe 所在的路径
F:\java\core\myslef\git\core\vip\src\main\java\dom\gupaoedu\vip\distributed\serialize\protobuf\protoc-3.12.3-win64\bin

// 第一个为输出的路径，第二个是proto文件的路径
protoc.exe --java_out=./ ./User.proto