path "C:/Users/r.merdeev/IdeaProjects/OpenCV/downloads/opencv/build/x64/vc15/bin"

opencv_createsamples.exe -info good.dat -num 2493 -vec samples.vec -maxxangle 0 -maxyangle 0 -maxzangle 0 -w 20 -h 20

pause

opencv_traincascade.exe -data haarcascade -vec samples.vec -bg bad.dat -numStages 16 -minhitrate 0.999 -maxFalseAlarmRate 0.4 -numPos 2000 -numNeg 1732 -w 20 -h 20 -mode ALL -precalcValBufSize 1024 -precalcIdxBufSize 1024

pause