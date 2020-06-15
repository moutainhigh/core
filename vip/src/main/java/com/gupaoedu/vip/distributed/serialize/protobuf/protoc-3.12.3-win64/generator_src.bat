@echo off

D:
set work_paths=D:\mafenglei\hengtian\ProtobufStudy-master\protobuf
cd %work_paths%

protoc.exe --java_out=./src/main/java proto/test.proto
protoc.exe --java_out=./src/main/java proto/person-entity.proto
pause
exit