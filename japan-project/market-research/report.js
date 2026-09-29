(() => {
  const button = document.querySelector('#mosaicToggle');
  const images = [...document.querySelectorAll('.toggle-image')];
  const heroBadge = [...document.querySelectorAll('.hero-meta span')].at(-1);

  function setMosaic(enabled) {
    images.forEach((image) => {
      image.src = enabled ? image.dataset.mosaic : image.dataset.raw;
    });
    button.classList.toggle('on', enabled);
    button.classList.toggle('off', !enabled);
    button.setAttribute('aria-pressed', String(enabled));
    button.querySelector('strong').textContent = enabled ? 'ON' : 'OFF';
    heroBadge.textContent = enabled ? '성인 이미지 모자이크 ON' : '성인 원본 이미지 표시 중';
    heroBadge.classList.toggle('raw-warning', !enabled);
  }

  button.addEventListener('click', () => {
    setMosaic(button.getAttribute('aria-pressed') !== 'true');
  });

  setMosaic(true);
})();
