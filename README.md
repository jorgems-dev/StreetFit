# StreetFit 🏋️‍♂️

API REST desarrollada con **Spring Boot** que ofrece servicios **CRUD personalizados** para la gestión de usuarios **Atletas** y **Entrenadores**. El proyecto utiliza **Hibernate/JPA** para la creación y gestión de la base de datos **MySQL**, y cuenta con un **cliente Android** desarrollado en **Android Studio con Java**, que consume la API mediante **Retrofit** para la comunicación cliente-servidor.

---

## 🚀 Características

* API REST siguiendo buenas prácticas
* Operaciones CRUD personalizadas
* Gestión de usuarios:

  * 🏃‍♂️ Atletas
  * 🧑‍🏫 Entrenadores
* Arquitectura por capas
* Uso de Spring Boot y Maven
* Preparada para ampliaciones futuras

---

## 🛠️ Tecnologías utilizadas

### Backend

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate** (ORM)
* **MySQL**
* **Maven**

### Cliente (Android)

* **Android Studio**
* **Java**
* **Retrofit** (consumo de API REST)
* * **XML (interfaz)** 


---

## 📁 Estructura del proyecto

```bash
├───main
│   ├───java
│   │   └───com
│   │       └───streetfit
│   │           └───apiFitServer
│   │               ├───configuracion
│   │               ├───controladores
│   │               ├───daos
│   │               ├───modelos
│   │               └───service
│   └───resources
│       ├───static
│       └───templates
└───test
    └───java
        └───com
            └───streetfit
                └───apiFitServer

```


## ⚙️ Configuración y ejecución

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/jorgems-dev/StreetFit.git
cd StreetFit
```
http://localhost:8080
```

---

## 📌 Endpoints principales (ejemplo)

### Atletas

* `GET /api/atletas`
* `GET /api/atletas/disponibles/{id}`
* `GET /api/atletas/correo/{correo}`
* `POST /api/atletas/registro`
* `POST /api/atletas/login`

### Entrenadores

* `GET /api/entrenadores`
* `GET /api/entrenadores/disponibles/{id}`
* `GET /api/entrenadores/correo/{correo}`
* `POST /api/entrenadores/registro`
* `POST /api/entrenadores/login`

### Rutinas

* `GET /api/rutinas`
* `GET /api/rutinas/creador/{identificacionCreador}`
* `POST /api/rutinas/crear`
* `PUT /api/rutinas/detalles-editar/{id}`
* `DELETE /api/rutinas/detalles-editar/{id}`

### Contratos

* `POST /api/rutinas`
* `POST /api/rutinas/baja`
---

## 🧩 Arquitectura

El proyecto está dividido en dos partes principales:

* **Backend**: API REST en Spring Boot encargada de la lógica de negocio y la persistencia de datos, utilizando Hibernate/JPA para mapear las entidades y generar la base de datos MySQL.
* **Cliente Android**: Aplicación móvil desarrollada en Android Studio con Java, que realiza peticiones HTTP a la API mediante Retrofit.

---

## 🔮 Próximas mejoras

* Autenticación y autorización (Spring Security + JWT)
* Relación entre Atletas y Entrenadores, para el uso de rutinas y asignaciones de rutinas nuevas o ya creda
* Persistencia en base de datos MySQL/PostgreSQL

---

## 👤 Autor

**Jorge**
GitHub: [jorgems-dev](https://github.com/jorgems-dev)

---

## 📄 Licencia

Este proyecto es de uso educativo y personal.
