package com.dhruv.mock_json

object CustomerMockData{
    val mockJson = """
        [
            {
                "personal_info": {
                    "name": "John Doe",
                    "mobile_number": "1234567890",
                    "emails": [
                        {"email": "john.doe@example.com", "password": "password123"},
                        {"email": "johndoe@gmail.com", "password": "doe456"}
                    ]
                },
                "shipment_details": {
                    "address": "123 Main St, City, Country",
                    "delivery_date": "2024-02-21"
                },
                "purchased_items": [
                    {"item_name": "Item 1", "quantity": 2, "price": 10.99},
                    {"item_name": "Item 2", "quantity": 1, "price": 25.49}
                ]
            },
            {
                "personal_info": {
                    "name": "Jane Smith",
                    "mobile_number": "9876543210",
                    "emails": [
                        {"email": "jane.smith@example.com", "password": "smith123"},
                        {"email": "janesmith@gmail.com", "password": "janey456"}
                    ]
                },
                "shipment_details": {
                    "address": "456 Oak St, Town, Country",
                    "delivery_date": "2024-02-22"
                },
                "purchased_items": [
                    {"item_name": "Item 3", "quantity": 1, "price": 15.99},
                    {"item_name": "Item 4", "quantity": 3, "price": 7.49}
                ]
            }
        ]
    """.trimIndent()
}