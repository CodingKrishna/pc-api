# pc-apis
Pioneer Coders java back end API's.  
Java API's for user managment and hr portal.  

mvn clean install  
mvn spring-boot:run  

##### Add user
```
https://pc-app-test.herokuapp.com/user/add
Method Post
request payload  
{
	"userName": "Siva",
	"mobileNo": "8050363568",
	"emailId": "siva@gmail.com",
	"password": "e10adc3949ba59abbe56e057f20f883e",
	"role": {
		"id": 1
	}
}
```
##### Login User
```
https://pc-app-test.herokuapp.com/login/user
Method Post
request payload
{
	"emailId": "siva@gmail.com",
	"password": "e10adc3949ba59abbe56e057f20f883e"
}
```

##### Get Technologies list
```
http://localhost:8081/pioneercodersdevv4.0/user/technologieslist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "name": "JAVA"
        },
        {
            "id": 2,
            "name": "HTML"
        },
        {
            "id": 3,
            "name": "CSS"
        }
    ]
}
```

##### Get Languages list
```
http://localhost:8081/pioneercodersdevv4.0/user/languageslist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "languageName": "Englist"
        }
    ]
}
```
#### Get Cities List 
```
http://localhost:8081/pioneercodersdevv4.0/user/getcitylist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "cityName": "Blr",
            "state": {
                "id": 1,
                "stateName": "AP",
                "country": {
                    "id": 1,
                    "countryName": "india"
                }
            }
        },
        {
            "id": 2,
            "cityName": "Hyd",
            "state": {
                "id": 1,
                "stateName": "AP",
                "country": {
                    "id": 1,
                    "countryName": "india"
                }
            }
        }
    ]
}
```

#### Get States List 
```
http://localhost:8081/pioneercodersdevv4.0/user/getstatelist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "stateName": "AP",
            "country": {
                "id": 1,
                "countryName": "india"
            }
        }
    ]
}

```

#### Get Country List 
```
http://localhost:8081/pioneercodersdevv4.0/user/getcountrylist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "countryName": "india"
        }
    ]
}

```

#### Get University List 
```
http://localhost:8081/pioneercodersdevv4.0/user/getuniversitylist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "universityName": "JNTU"
        }
    ]
}
```

#### Get University List 
```
http://localhost:8081/pioneercodersdevv4.0/user/getinstitutelist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "instituteName": "BVC",
            "university": {
                "id": 1,
                "universityName": "JNTU"
            },
            "collegePhoneNo": "123",
            "startDate": 1579717800000,
            "description": "abc",
            "poId": {
                "id": 15,
                "userName": "Krishna",
                "emailId": "codingkrishna@gmail.com",
                "mobileNo": "8123870076",
                "password": "e10adc3949ba59abbe56e057f20f883e",
                "status": "ACTIVE",
                "role": {
                    "id": 1,
                    "roleName": "Anonymous"
                },
                "createdOn": 1567881000000,
                "isVisible": true,
                "examCompleted": null
            }
        }
    ]
}
```

#### Get project domain List 
```
http://localhost:8081/pioneercodersdevv4.0/user/getprojectdomainlist
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": [
        {
            "id": 1,
            "projectDomainName": "E-Commerce"
        }
    ]
}
```

#### Get User Complete Profile 
```
http://localhost:8081/pioneercodersdevv4.0/user/completedata?userId=15
Method Get
request payload
Response:
{
    "status": "success",
    "errordetail": null,
    "isSuccess": true,
    "response": {
        "user": {
            "id": 15,
            "userName": "Krishna",
            "emailId": "codingkrishna@gmail.com",
            "mobileNo": "8123870076",
            "password": "e10adc3949ba59abbe56e057f20f883e",
            "status": "ACTIVE",
            "role": {
                "id": 1,
                "roleName": "Anonymous"
            },
            "createdOn": 1567881000000,
            "isVisible": true,
            "examCompleted": null
        },
        "education": [],
        "project": [],
        "skill": {
            "techskills": [
                {
                    "id": 1,
                    "technology": {
                        "id": 1,
                        "name": "JAVA"
                    },
                    "user": {
                        "id": 15,
                        "userName": "Krishna",
                        "emailId": "codingkrishna@gmail.com",
                        "mobileNo": "8123870076",
                        "password": "e10adc3949ba59abbe56e057f20f883e",
                        "status": "ACTIVE",
                        "role": {
                            "id": 1,
                            "roleName": "Anonymous"
                        },
                        "createdOn": 1567881000000,
                        "isVisible": true,
                        "examCompleted": null
                    }
                },
                {
                    "id": 2,
                    "technology": {
                        "id": 2,
                        "name": "HTML"
                    },
                    "user": {
                        "id": 15,
                        "userName": "Krishna",
                        "emailId": "codingkrishna@gmail.com",
                        "mobileNo": "8123870076",
                        "password": "e10adc3949ba59abbe56e057f20f883e",
                        "status": "ACTIVE",
                        "role": {
                            "id": 1,
                            "roleName": "Anonymous"
                        },
                        "createdOn": 1567881000000,
                        "isVisible": true,
                        "examCompleted": null
                    }
                }
            ],
            "basicSkills": null
        },
        "social": null,
        "employersInfo": [],
        "languages": [],
        "userExperianceInfo": null,
        "purchaseCourseDto": null,
        "address": null,
        "userBasicInfo": {
            "id": 1,
            "profileSummary": "hey im using app.",
            "resumePath": null,
            "selfIntroVideoPath": null,
            "dob": 1579804200000,
            "languages": null,
            "user": {
                "id": 15,
                "userName": "Krishna",
                "emailId": "codingkrishna@gmail.com",
                "mobileNo": "8123870076",
                "password": "e10adc3949ba59abbe56e057f20f883e",
                "status": "ACTIVE",
                "role": {
                    "id": 1,
                    "roleName": "Anonymous"
                },
                "createdOn": 1567881000000,
                "isVisible": true,
                "examCompleted": null
            }
        }
    }
}
```

##### Add basic info
```
http://localhost:8081/pioneercodersdevv4.0/user/addbasicinfo
Method Post
request payload
{
	"userBasicProfile": {
		"id": 1,
		"profileSummary": "hey im using app.",
		"resumePath": null,
		"selfIntroVideoPath": null,
		"dob": "2020-02-01T18:30:00.000Z",
		"languages": [{
			"language": {
				"id": 1
			},
			"user": {
				"id": 15
			}
		}],
		"user": {
			"id": 15
		}
	},
	"techskills": [{
		"user": {
			"id": 15
		},
		"technology": {
			"id": 1
		}
	}, {
		"user": {
			"id": 15
		},
		"technology": {
			"id": 3
		}
	}]
}
```


##### Add Address info
```
http://localhost:8081/pioneercodersdevv4.0/user/updateaddress
Method Post
request payload
{
	"address": "#91",
	"city": {
		"id": 1
	},
	"state": {
		"id": 1
	},
	"country": {
		"id": 1
	},
	"pincode": "560068",
	"user": {
		"id": 15
	}
}
```

##### Add Education info
```
http://localhost:8081/pioneercodersdevv4.0/user/addeducation
Method Post
request payload
{
	"education": [{
		"educationType": "SSC",
		"branch": "CSC",
		"yearOfPassing": "2020",
		"percentage": "90",
		"institute": {
			"id": 1
		},
		"university": {
			"id": 1
		},
		"user": {
			"id": 15
		}
	}]
}
```

##### Add Skill set info
```
http://localhost:8081/pioneercodersdevv4.0/user/addskills
Method Post
request payload
{
	"skill": {
		"techskills": [{
			"user": {
				"id": 15
			},
			"technology": {
				"id": 1
			}
		}, {
			"user": {
				"id": 15
			},
			"technology": {
				"id": 3
			}
		}, {
			"user": {
				"id": 15
			},
			"technology": {
				"id": 2
			}
		}],
		"basicSkills": {
			"commRating": 4,
			"analyticalRating": 4,
			"user": {
				"id": 15
			}
		}
	}
}
```

##### Add total ToWorkExp info
```
http://localhost:8081/pioneercodersdevv4.0/user/addexperianceinfo
Method Post
request payload
{
	"curentSalaryInLakhs": "2",
	"curentSalaryInThousands": "20",
	"expectedSalaryInLakhs": "6",
	"expectedSalaryInThousands": "60",
	"yearsOfExperiance": "9",
	"monthsOfExperiace": "5",
	"user": {
		"id": 15
	}
}
```

##### Add Empoyer info
```
http://localhost:8081/pioneercodersdevv4.0/user/addemployerinfo
Method Post
request payload
{
	"employersInfo": [{
		"employer": "PC",
		"employerStatus": "Current Employer",
		"monthStart": "February",
		"yearStart": "1974",
		"monthEnd": "April",
		"yearEnd": "1977",
		"designation": "asd",
		"jobProfile": "asadds",
		"user": {
			"id": 15
		}
	}]
}
```

##### Add Projects info
```
http://localhost:8081/pioneercodersdevv4.0/user/addproject
Method Post
request payload
{
	"project": [{
		"projectTitle": "ASD",
		"desc": "dghj",
		"startDate": 1579285800000,
		"endDate": 1581100200000,
		"responsibilities": "asd",
		"projectdomain": {
			"id": 1
		},
		"user": {
			"id": 15
		}
	}]
}
```


##### Add Social info
```
http://localhost:8081/pioneercodersdevv4.0/user/addsocialinfo
Method Post
request payload
{
	"facebookId": "asd",
	"twitterId": "aaa",
	"skypeId": "bb",
	"whatsappNo": "12345",
	"user": {
		"id": 15
	}
}
```

##### Add Settings info
```
http://localhost:8081/pioneercodersdevv4.0/user/updateuserisvisible?isVisible=true&userId=15
Method Get
```


