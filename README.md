# Modelo_Cliente_Servidor_CHAT

## Puertos para usar (Verificar con el comando de netstat si está disponible)

_1024 - 49151_

## Abrir puertos en la página del router.

_Protocolo tipo: TCP_
_Habilitar Port Forwarding (Si tu router tiene esa opción)_

_Agregar una nueva regla de SALIDA en el firewall_
	       _O_
_desactivar directamente todo el firewall._

## Opcional(?)

_Añadir IP en el archivo HOSTS de System32 (el archivo especifica como se tiene que agregar)_
_C:\Windows\System32\drivers\etc_

## Páginas para verificar puertos y dirección IP:

* [CanYouSeeMe](https://canyouseeme.org/) 
* [YouGetSignal](https://www.yougetsignal.com/tools/open-ports/)

## Comandos útiles para CMD

_netstat -na | findstr "numero_puerto"_
```
netstat -na | findstr "8888"
```
_telnet dirección_ip numero_puerto_
```
telnet 127.0.0.1 8888
```

## Error de conexiones:
_Connection time out - lado del cliente  //La ip que va a usar el cliente tiene que ser la que se muestra publicamente_

_Connection refused - lado del server   //La ip del servidor tiene que ser IPv4_
