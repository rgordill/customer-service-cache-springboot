# -*- coding: utf-8 -*-
 
import random
import csv

items = []

def read_csv(filename):
    with open(filename, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            items.append(row['customerId'])

def random_customer_id():

    return random.choice(items)