async function generateChart() {
    // Write your code here. You can write your own function(s) if you want.
    var countryCount = document.getElementById('numberOfCountries').value;
    
    const response = await fetch("https://restcountries.com/v3.1/all");
    const countryData = await response.json();
    var countryNames = countryData.map(n => n.name.common);
    var countryPops = countryData.map(n => n.population);
    console.log(countryData);
    countryNames = countryNames.slice(0, countryCount);
    countryPops = countryPops.slice(0, countryCount);
    
    console.log(countryNames);

    var ctx = document.getElementById("barChart");

    new Chart(ctx, {
        type: 'bar',
        data: {
        labels: countryNames,
        datasets: [{
            label: 'Total Population',
            data: countryPops,
        }]
        },
        options: {
        scales: {
            y: {
            beginAtZero: true
            }
        }
        }
    });
  };