package br.com.cast.challenge.product;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "classpath:features/products", dryRun = false, glue = {"br.com.cast.challenge.products.steps"})
public class ProductIntegrationTest {

}
