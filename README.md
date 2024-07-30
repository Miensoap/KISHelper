# KISHelper

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

KISHelper is a Java library for interacting with the Korea Investment Open API.  
This library simplifies the process of accessing and using the API,   
providing a more efficient way to integrate financial data into your applications.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
- Easy integration with the Korea Investment Open API
- Simplified data retrieval
- Lightweight and efficient

## Installation

Add the following to your `build.gradle` file to include KISHelper in your project:

```groovy
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation 'io.github.miensoap:KISHelper:0.1.0-test'
}
```

Add your [KIS Open API key](https://apiportal.koreainvestment.com/intro) to `resources/kish.yml` file:

```yaml
appkey: 'your_appkey'
appsecret: 'your_secret_key'
accessToken: 'your_access_token' (optional)
```
[*How to get your accessToken*](https://apiportal.koreainvestment.com/apiservice/oauth2#L_fa778c98-f68d-451e-8fff-b1c6bfe5cd30) 

## Usage

### Example

```java
// Example usage of KISHelper library
package io.github.miensoap.kishelper;

import io.github.miensoap.kishelper.core.KISClient;
import io.github.miensoap.kishelper.util.ConfigLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        KISClient kisClient = KISClient.getInstance();
        System.out.println(ConfigLoader.getAccessToken());
        System.out.println(kisClient.getOverseasDailyPrice("AMS", "SOXL", false).size());
    }
}
```

For more detailed usage, please refer to the [documentation](https://github.com/Miensoap/KISHelper.git).

## Contributing

We welcome contributions to the KISHelper project. Please read our [Contributing Guidelines](CONTRIBUTING.md) for more information on how to get started.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

Developer: Miensoap  
Email: miensop51@gmail.com  
GitHub: [Miensoap](https://github.com/Miensoap)

## Acknowledgements

Special thanks to all the contributors who helped in making this project better.

---

Feel free to customize this README file further as per your needs.