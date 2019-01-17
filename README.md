# Serverside Scraper

A Java console application which scrapes this grocery [URL](https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html) and returns the products in a JSON array.

>The resulting JSON array has `title`, `unit_price`, `kcal_per_100g` and `description` fields for each of the products and then an overall `total` with the `gross` and `vat` amount.
 
 The resulting JSON output:-
 ```json
{
    "products": [{
        "title": "Sainsbury's Strawberries 400g",
        "energy": 33,
        "price": 1.75,
        "description": "by Sainsbury's strawberries"
    }, {
        "title": "Sainsbury's Blueberries 200g",
        "energy": 45,
        "price": 1.75,
        "description": "by Sainsbury's blueberries"
    }, {
        "title": "Sainsbury's Raspberries 225g",
        "energy": 32,
        "price": 1.75,
        "description": "by Sainsbury's raspberries"
    }, {
        "title": "Sainsbury's Blackberries, Sweet 150g",
        "energy": 32,
        "price": 1.50,
        "description": "by Sainsbury's blackberries"
    }, {
        "title": "Sainsbury's Blueberries 400g",
        "energy": 45,
        "price": 3.25,
        "description": "by Sainsbury's blueberries"
    }, {
        "title": "Sainsbury's Blueberries, SO Organic 150g",
        "energy": 45,
        "price": 2.00,
        "description": "So Organic blueberries"
    }, {
        "title": "Sainsbury's Raspberries, Taste the Difference 150g",
        "energy": 32,
        "price": 2.50,
        "description": "Ttd raspberries"
    }, {
        "title": "Sainsbury's Cherries 400g",
        "energy": 52,
        "price": 2.50,
        "description": "by Sainsbury's Family Cherry Punnet"
    }, {
        "title": "Sainsbury's Blackberries, Tangy 150g",
        "energy": 32,
        "price": 1.50,
        "description": "by Sainsbury's blackberries"
    }, {
        "title": "Sainsbury's Strawberries, Taste the Difference 300g",
        "energy": 33,
        "price": 2.50,
        "description": "Ttd strawberries"
    }, {
        "title": "Sainsbury's Cherry Punnet 200g",
        "energy": 52,
        "price": 1.50,
        "description": "Cherries"
    }, {
        "title": "Sainsbury's Mixed Berries 300g",
        "price": 3.50,
        "description": "by Sainsbury's mixed berries"
    }, {
        "title": "Sainsbury's Mixed Berry Twin Pack 200g",
        "price": 2.75,
        "description": "Mixed Berries"
    }, {
        "title": "Sainsbury's Redcurrants 150g",
        "energy": 71,
        "price": 2.50,
        "description": "by Sainsbury's redcurrants"
    }, {
        "title": "Sainsbury's Cherry Punnet, Taste the Difference 200g",
        "energy": 48,
        "price": 2.50,
        "description": "Cherry Punnet"
    }, {
        "title": "Sainsbury's Blackcurrants 150g",
        "price": 1.75,
        "description": ""
    }, {
        "title": "Sainsbury's British Cherry & Strawberry Pack 600g",
        "price": 4.00,
        "description": "British Cherry & Strawberry Mixed Pack"
    }],
    "total": {
        "gross": 39.50,
        "vat": 6.58
    }
}
```

### Building and running

To build the project, in the build directory run the build command. You can use the regular gradle command, as this project includes a wrapper script, you can run:

````
./gradlew build
````
and then to run use
````
./gradlew run
````

### Tests

The tests are run as part of the build and can be run individually by 

```
./gradlew test
```

You can view the test report by opening the HTML output file, located at 
```
build/reports/tests/test/index.html
```

#### Future Improvements

* Use a framework like spring boot or dropwizard
* Have a URL passed in rather that a hardcoded link in Main class
* Dependency Injection




