# İlk olarak kullanılacak jdk sistemi ve türü seçilir.
FROM amazoncorretto:17.0.6-al2
# oluşturulacak imajın içine çalıştıracağınız jar dosyasının kopyalanması
# orn1: COPY build/libs/Java6Mono-0.0.1-SNAPSHOT.jar app.jar
# ayrıca tek dosya üzerinden(Dockerfile) farklı projeleri import etmek için
# Arguman kullanarak işlem yapabilirsiniz.
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#Eğer güncelleme yapmak isterseniz bu komut eklenebilir.
#CMD apt-get update -y
# son olarak da jar dosyasının çalışması için tetikliyorum
#DİKKAT lütfen bitişik yazmayın.
ENTRYPOINT ["java","-jar","/app.jar"]