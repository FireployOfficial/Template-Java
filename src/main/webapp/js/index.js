function generateRays() {
    const totalSpikes = 16;
    const radius = '180%'; // Puedes cambiar esto por px si prefieres
    const container = document.getElementById('containerRays');

    for (let i = 0; i < totalSpikes; i++) {
        const angle = (360 / totalSpikes) * i;
        const ray = document.createElement('div');
        ray.classList.add('ray');
        ray.style.transform = `rotate(${angle}deg) translate(${radius})`;
        container.appendChild(ray);
    }

}

generateRays();

const redirect = document.createElement('a');
redirect.href = './pages/start.html';
redirect.style.display = 'none';
document.body.appendChild(redirect);

document.getElementById('navigation').onclick = (e) => {
  redirect.click();
};