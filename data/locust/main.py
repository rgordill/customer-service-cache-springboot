# -*- coding: utf-8 -*-

import os

from locust import HttpUser, task, between, constant
from lib.random_data import read_csv, random_customer_id

default_headers = {"content-headers": "application/json"}

read_csv(os.environ['CSV_FILE'])

class WebsiteUser(HttpUser):
    wait_time = constant(0.1)

    # @task(1)
    # def get_index(self):
    #     customer_data = '{"first-name": "string","last-name": "string","email": "string"}'
    #     self.client.post("/customer", headers=default_headers)

    @task(2)
    def get_customer_id(self):
        self.client.get("/customer/" + random_customer_id(), headers=default_headers)