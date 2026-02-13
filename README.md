
## 🛠 Steps to Create Spring Boot Project
### 1️⃣ Open Spring Initializr  
Go to:  
👉 https://start.spring.io/
---
### 2️⃣ Select Project Options  
Choose:
- **Project** → `Maven Project` ✅  
- **Language** → `Java`  
- **Spring Boot** → Latest stable version  
- **Packaging** → `Jar`  
- **Java** → `17` (or 11/8 based on your setup)
---
### 3️⃣ Fill Project Metadata  
Example:
| Field        | Example Value         |
|-------------|------------------------|
| Group       | com.example            |
| Artifact    | demo                   |
| Name        | demo                   |
| Description | Simple Spring Web App  |
| Package     | com.example.demo       |
---
### 4️⃣ Add Dependency  
Click **Add Dependencies** → Select :
- ✅ **Spring Web**
This adds REST API and embedded Tomcat support.
---
### 5️⃣ Generate Project  
Click **GENERATE** → Download the ZIP file.
---
### 6️⃣ Import into IDE  
Unzip and open the project:
- **Eclipse** → Import → Existing Maven Project  
---
### 7️⃣ Run the Application  
