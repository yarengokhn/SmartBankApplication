# Android Studio Klavye Kısayolları Sorun Giderme Rehberi

Eğer Android Studio'da klavye kısayolları (örneğin `Alt + Enter`, `Ctrl + Shift + F`, `Ctrl + Space`) çalışmıyorsa, aşağıdaki adımları takip ederek sorunu çözebilirsiniz:

## 1. Keymap Ayarlarını Kontrol Edin
Android Studio'nun hangi klavye düzenini kullandığını kontrol edin:
- **File > Settings** (Windows) veya **Android Studio > Settings** (macOS) menüsüne gidin.
- Sol menüden **Keymap**'i seçin.
- En üstteki açılır menüden **Windows**, **Default** veya **macOS** gibi doğru düzenin seçili olduğundan emin olun.
- Eğer bir değişiklik yaptıysanız, sağ üstteki "Restore" butonu ile varsayılana dönebilirsiniz.

## 2. IdeaVim Eklentisini Kontrol Edin
Eğer **IdeaVim** eklentisi yüklüyse, bu eklenti çoğu standart kısayolu (özellikle kopyala/yapıştır ve yön tuşları) devre dışı bırakabilir veya kendi moduna alabilir.
- Alt köşedeki **V** simgesine tıklayarak Vim modunu kapatabilir veya eklentiyi **Settings > Plugins** kısmından devre dışı bırakabilirsiniz.

## 3. Diğer Uygulamalarla Çakışma
Bazı arka plan uygulamaları (örneğin ekran kartı yazılımları, mesajlaşma uygulamaları veya Windows'un kendi kısayolları) Android Studio'nun tuş kombinasyonlarını yakalıyor olabilir.
- Özellikle `Ctrl + Alt + L` (kod formatlama) veya `Alt + Enter` gibi tuşların başka bir program tarafından kullanılıp kullanılmadığını test edin.

## 4. IDE'yi Yeniden Başlatın ve Önbelleği Temizleyin
Bazen IDE'nin içindeki bir işlem takılı kalmış olabilir:
- **File > Invalidate Caches...** seçeneğine tıklayın.
- Tüm kutucukları işaretleyip **Invalidate and Restart** butonuna basın.

## 5. Odaklanma (Focus) Sorunu
Eğer Preview (Önizleme) penceresi veya Logcat penceresi odaklanmış durumdaysa, editör kısayolları bazen çalışmayabilir. Editörün içine bir kez tıklayarak odağın orada olduğundan emin olun.

> [!TIP]
> Eğer belirli bir kısayolun (örneğin sadece `Alt + Enter`) çalışmadığını fark ederseniz, Keymap ayarlarında sağdaki büyüteç simgesine tıklayarak o tuş kombinasyonunu aratın. Hangi işlemin atandığını buradan görebilirsiniz.
